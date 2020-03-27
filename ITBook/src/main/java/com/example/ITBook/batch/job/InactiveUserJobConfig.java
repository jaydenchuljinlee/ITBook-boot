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
* 1�� �̻� �޸� ���� ��Ȱ��ȭ ��ġ
* @author : cheoljin
* */
@AllArgsConstructor
@Configuration
@Slf4j
public class InactiveUserJobConfig {

	private UserRepository userRepository;// ���� ���� Repository

	private static final int CHUNK_SIZE         = 15;//ûũ(�� ���� ó���� JOB) ������
	private static final int MULTY_FLOW_SIZE    = 5;// ��Ƽ �÷ο� ������
	private static final int PARTITION_SIZE     = 5;// ��Ƽ�� ������
	private static final int MULIY_THREAD_SIZE  = 2;// ��Ƽ ������ ������
    private static final int HUMENT_YEAR        = 1;// �޸� ������ ������ ���
	private final EntityManagerFactory entityManagerFactory;//���Ӽ� ���� ��ü

    //Job �� ���
    @Bean
    public Job inactiveUserJob(JobBuilderFactory jobBuilderFactory
                                ,InactiveJobListener inactiveJobListener, Step partitionerStep) {

        log.info("InactiveUserJobConfig.inactiveUserJob :::");

        return jobBuilderFactory.get("InactiveUserJob")//InactiveUserJob�̶�� �̸��� JobBuilder�� ����
                //.preventRestart()// Job�� ������� ���´�
                .listener(inactiveJobListener)
                .start(partitionerStep) // inactivejobStep�� ���� ���� ���� �ǵ��� ����
                .build();

    }

    /*
    * partitioner ������� flow�� ����
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

    //Step �� ���
    @Bean
    public Step inactiveUserJobStep(StepBuilderFactory stepBuilderFactory, ListItemReader<User> inactiveUserReader
                                , InactiveJobListener inactiveJobListener, TaskExecutor taskExecutor) {

        log.info("InactiveUserJobConfig.inactiveUserJobStep :::");

        return stepBuilderFactory.get("inactiveUserJobStep")//inactiveUserJobStep��� �̸��� StepBuilder ����
                .<User, User> chunk(CHUNK_SIZE) // chunk I/O Ÿ�� ����, Ŀ�� ���� 10
                .reader(inactiveUserReader) // Step�� reader,processor,writer ����
                .processor(inactiveUserProcessor())
                .writer(activeUserWriter())
                .listener(inactiveJobListener)
                .taskExecutor(taskExecutor)
                .throttleLimit(MULIY_THREAD_SIZE)
                .build();
    }

    /*
    * ���� ����
    * */
    @Bean
    public TaskExecutor taskExecutor() {

        log.info("InactiveUserJobConfig.taskExecutor :::");

        return new SimpleAsyncTaskExecutor("Batch_Task");
    }

    /*
    * ������ ���̽����� ��ġ ó���� �����͸� �ҷ����� �۾�
    * ����Ʈ Ÿ������ ITemReder�� �ҷ���
    * */
    @StepScope
    @Bean
    public ListItemReader<User> inactiveUserReader(@Value("#{stepExecutionContext[grade]}") String grade,
                                                        UserRepository userRepository) {

        log.info("current thread name is {}", Thread.currentThread().getName());

        //1���� ���� ���°� ACTIVE�� ������
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

        jpaPagingItemReader.setParameterValues(map);// ������ ����� �Ķ���� ����
        jpaPagingItemReader.setEntityManagerFactory(entityManagerFactory);//Ʈ����� ����
        jpaPagingItemReader.setPageSize(CHUNK_SIZE);//�� ���� �о�� ũ�� ����*/

        return new ListItemReader<>(oldUsers);
    }

    /*
    * ��ġ �۾� ó��
    * */
    @Bean
    public ItemProcessor<User,User> inactiveUserProcessor() {
        return User::setInactive;// �޸� ��ȯ

    }

    /*
    * ��ġ �۾� ó�� �� ������ ���̽��� ����
    *  entityManagerFactory�� �����ϸ�, processor���� �Ѿ�� �����͸� ûũ ������ �����Ѵ�.
    * */
    @Bean
    public ItemWriter<User> activeUserWriter() {
        JpaItemWriter<User> jpaItemWriter = new JpaItemWriter<>();

        jpaItemWriter.setEntityManagerFactory(entityManagerFactory);

        return jpaItemWriter;
    }

    /*****************************************************************************/
    // ��ġ ������ ó�� ���. ���� ��Ƽ�Ŵ� ������� �����߰�, �� ���� �Ʒ� ���� Flow�� ��Ƽ Flow�� �����߽��ϴ�.
    // ���� �Ʒ� ���� ���� ����ϰ� ���� �ʱ� ������ Bean�� ����������ϴ�.

    /*
     * ��Ƽ �÷ο�� ������ ó��
     * @Bean ����
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
     * ���� �÷ο�� ������ ó��
     * @Bean ����
     * @Param : inactiveUserJobStep
     * @Return
     * */
    public Flow inactiveJobFlow(Step inactiveUserJobStep) {

        log.info("InactiveUserJobConfig.inactiveJobFlow :::");

        FlowBuilder<Flow> flowBuilder = new FlowBuilder<>("inactiveJobFlow");

        return flowBuilder
                .start(new InactiveJobExecutionDecider())//Job�� �����ų���� ����
                .on(FlowExecutionStatus.FAILED.getName()).end()
                .on(FlowExecutionStatus.COMPLETED.getName()).to(inactiveUserJobStep).end();

    }
}
