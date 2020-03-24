package com.example.ITBook.batch.job;

import com.example.ITBook.batch.readers.QueueItemReader;
import com.example.ITBook.common.domain.User;
import com.example.ITBook.common.enums.UserStatus;
import com.example.ITBook.user.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.JpaItemWriter;
import org.springframework.batch.item.database.JpaPagingItemReader;
import org.springframework.batch.item.support.ListItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import javax.persistence.EntityManagerFactory;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Configuration
public class InactiveUserJobConfig {

	private UserRepository userRepository;

	private static final int CHUNK_SIZE = 15;
	private final EntityManagerFactory entityManagerFactory;

    //Job 빈 등록
    @Bean
    public Job inactiveUserJob(JobBuilderFactory jJobBuilderFactory, Step inactivejobStep) {
        return jJobBuilderFactory.get("InactiveUserJob")//InactiveUserJob이라는 이름의 JobBuilder를 생성
                .preventRestart()// Job의 재실행을 막는다
                .start(inactivejobStep) // inactivejobStep이 제일 먼저 실행 되도록 설정
                .build();

    }

    //Step 빈 등록
    @Bean
    public Step inactiveUserStep(StepBuilderFactory stepBuilderFactory, ListItemReader<User> inactiveUserReader) {

        return stepBuilderFactory.get("inactiveUserStep")//inactiveUserStep라는 이름의 StepBuilder 생성
                .<User, User> chunk(CHUNK_SIZE) // chunk I/O 타입 설정, 커밋 단위 10
                .reader(inactiveUserReader) // Step의 reader,processor,writer 설정
                .processor(inactiveUserProcessor())
                .writer(activeUserWriter())
                .build();
    }

    @StepScope
    @Bean
    public ListItemReader<User> inactiveUserReader(@Value("#{jobParameters[nowDate]}") Date nowDate,
                                                        UserRepository userRepository) {

        LocalDateTime now = LocalDateTime.ofInstant(nowDate.toInstant(), ZoneId.systemDefault());

        List<User> oldUsers = userRepository.findByUpdatedDateBeforeAndStatusEquals(now.minusYears(1),UserStatus.ACTIVE);

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

    @Bean
    public ItemProcessor<User,User> inactiveUserProcessor() {
        return User::setInactive;// 휴면 전환

    }

    /*
    *  entityManagerFactory만 설정하면, processor에서 넘어온 데이터를 청크 단위로 저장한다.
    * */
    @Bean
    public ItemWriter<User> activeUserWriter() {
        JpaItemWriter<User> jpaItemWriter = new JpaItemWriter<>();

        jpaItemWriter.setEntityManagerFactory(entityManagerFactory);

        return jpaItemWriter;
    }
}
