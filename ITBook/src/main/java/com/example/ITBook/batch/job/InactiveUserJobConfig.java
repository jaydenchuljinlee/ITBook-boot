package com.example.ITBook.batch.job;

import com.example.ITBook.batch.job.decider.InactiveJobExecutionDecider;
import com.example.ITBook.batch.job.listener.InactiveJobListener;
import com.example.ITBook.common.domain.User;
import com.example.ITBook.common.enums.UserStatus;
import com.example.ITBook.user.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.job.builder.FlowBuilder;
import org.springframework.batch.core.job.flow.Flow;
import org.springframework.batch.core.job.flow.FlowExecutionStatus;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.JpaItemWriter;
import org.springframework.batch.item.support.ListItemReader;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;

import javax.persistence.EntityManagerFactory;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.IntStream;


/*
* 1년 이상 휴면 유저 비활성화 배치
* @author : cheoljin
* */
@AllArgsConstructor
@Configuration
@Slf4j
public class InactiveUserJobConfig {

	private UserRepository userRepository;// 유저 정보 Repository

	private static final int CHUNK_SIZE         = 15;//청크(한 번에 처리할 JOB) 사이즈
	private static final int MULTY_FLOW_SIZE    = 5;// 멀티 플로우 사이즈
	private static final int PARTITION_SIZE     = 5;// 파티션 사이즈
	private static final int MULIY_THREAD_SIZE  = 2;// 멀티 스레드 사이즈
    private static final int HUMENT_YEAR        = 1;// 휴면 유저를 결정할 년수
	private final EntityManagerFactory entityManagerFactory;//영속성 관리 객체

    //Job 빈 등록
    @Bean
    public Job inactiveUserJob(JobBuilderFactory jobBuilderFactory
                                ,InactiveJobListener inactiveJobListener, Step partitionerStep) {

        log.info("InactiveUserJobConfig.inactiveUserJob :::");

        return jobBuilderFactory.get("InactiveUserJob")//InactiveUserJob이라는 이름의 JobBuilder를 생성
                //.preventRestart()// Job의 재실행을 막는다
                .listener(inactiveJobListener)
                .start(partitionerStep) // inactivejobStep이 제일 먼저 실행 되도록 설정
                .build();

    }

    /*
    * partitioner 방식으로 flow를 진행
    * @param : inactiveUserJobStep
    * @return
    * */
    @Bean
    @JobScope
    public Step partitionerStep(StepBuilderFactory stepBuilderFactory, Step inactiveUserJobStep) {

        log.info("InactiveUserJobConfig.partitionerStep :::");

        return stepBuilderFactory
                .get("partitionerStep")
                .partitioner("partitionerStep",new InactiveJobPartitioner())
                .gridSize(PARTITION_SIZE)
                .step(inactiveUserJobStep)
                .taskExecutor(taskExecutor())
                .build();
    }

    //Step 빈 등록
    @Bean
    public Step inactiveUserJobStep(StepBuilderFactory stepBuilderFactory, ListItemReader<User> inactiveUserReader
                                , InactiveJobListener inactiveJobListener, TaskExecutor taskExecutor) {

        log.info("InactiveUserJobConfig.inactiveUserJobStep :::");

        return stepBuilderFactory.get("inactiveUserJobStep")//inactiveUserJobStep라는 이름의 StepBuilder 생성
                .<User, User> chunk(CHUNK_SIZE) // chunk I/O 타입 설정, 커밋 단위 10
                .reader(inactiveUserReader) // Step의 reader,processor,writer 설정
                .processor(inactiveUserProcessor())
                .writer(activeUserWriter())
                .listener(inactiveJobListener)
                .taskExecutor(taskExecutor)
                .throttleLimit(MULIY_THREAD_SIZE)
                .build();
    }

    /*
    * 업무 실행
    * */
    @Bean
    public TaskExecutor taskExecutor() {

        log.info("InactiveUserJobConfig.taskExecutor :::");

        return new SimpleAsyncTaskExecutor("Batch_Task");
    }

    /*
    * 데이터 베이스에서 배치 처리할 데이터를 불러오는 작업
    * 리스트 타입으로 ITemReder를 불러옴
    * */
    @StepScope
    @Bean
    public ListItemReader<User> inactiveUserReader(@Value("#{stepExecutionContext[grade]}") String grade,
                                                        UserRepository userRepository) {

        log.info("current thread name is {}", Thread.currentThread().getName());

        //1년이 지난 상태가 ACTIVE인 유저들
        List<User> oldUsers = userRepository.findByUpdatedDateBeforeAndStatusEquals(LocalDateTime.now().minusYears(HUMENT_YEAR),UserStatus.ACTIVE);


        //LocalDateTime now = LocalDateTime.ofInstant(nowDate.toInstant(), ZoneId.systemDefault());

        //List<User> oldUsers = userRepository.findByUpdatedDateBeforeAndStatusEquals(now.minusYears(1),UserStatus.ACTIVE);


        /*JpaPagingItemReader<User> jpaPagingItemReader = new JpaPagingItemReader() {
            @Override
            public int getPage() {return 0;}
        };
        String OldUserSelectQuery = "select u " +
                                    "from User as u " +
                                    "where u.updated_date < :updatedDate and u.status = :status";

        jpaPagingItemReader.setQueryString(OldUserSelectQuery);

        Map<String,Object> map = new HashMap<String,Object>();
        map.put("updatedDate",LocalDateTime.now().minusYears(1));
        map.put("status",UserStatus.ACTIVE);

        jpaPagingItemReader.setParameterValues(map);// 쿼리에 사용할 파라미터 지정
        jpaPagingItemReader.setEntityManagerFactory(entityManagerFactory);//트랜잭션 관리
        jpaPagingItemReader.setPageSize(CHUNK_SIZE);//한 번에 읽어올 크기 지정*/

        return new ListItemReader<>(oldUsers);
    }

    /*
    * 배치 작업 처리
    * */
    @Bean
    public ItemProcessor<User,User> inactiveUserProcessor() {
        return User::setInactive;// 휴면 전환

    }

    /*
    * 배치 작업 처리 후 데이터 베이스에 저장
    *  entityManagerFactory만 설정하면, processor에서 넘어온 데이터를 청크 단위로 저장한다.
    * */
    @Bean
    public ItemWriter<User> activeUserWriter() {
        JpaItemWriter<User> jpaItemWriter = new JpaItemWriter<>();

        jpaItemWriter.setEntityManagerFactory(entityManagerFactory);

        return jpaItemWriter;
    }

    /*****************************************************************************/
    // 배치 예제를 처리 방법. 현재 파티셔닝 방식으로 진행했고, 그 전에 아래 단일 Flow와 멀티 Flow로 진행했습니다.
    // 따라서 아래 빈은 현재 사용하고 있지 않기 때문에 Bean을 삭제해줬습니다.

    /*
     * 멀티 플로우로 스텝을 처리
     * @Bean 삭제
     * @Param : inactiveUserJobStep
     * @Return
     * */
    public Flow multiFlow(Step inactiveUserJobStep) {

        log.info("InactiveUserJobConfig.multiFlow :::");

        Flow[] flows = new Flow[MULTY_FLOW_SIZE];

        IntStream.range(0,flows.length).forEach(i -> {
            flows[i] = new FlowBuilder<Flow>("MultiFlow"+i)
                    .from(inactiveJobFlow(inactiveUserJobStep)).end();

        });

        return new FlowBuilder<Flow>("MultiFlowTest")
                .split(taskExecutor())
                .add(flows)
                .build();
    }

    /*
     * 단일 플로우로 스텝을 처리
     * @Bean 삭제
     * @Param : inactiveUserJobStep
     * @Return
     * */
    public Flow inactiveJobFlow(Step inactiveUserJobStep) {

        log.info("InactiveUserJobConfig.inactiveJobFlow :::");

        FlowBuilder<Flow> flowBuilder = new FlowBuilder<>("inactiveJobFlow");

        return flowBuilder
                .start(new InactiveJobExecutionDecider())//Job을 실행시킬지를 결정
                .on(FlowExecutionStatus.FAILED.getName()).end()
                .on(FlowExecutionStatus.COMPLETED.getName()).to(inactiveUserJobStep).end();

    }
}
