package com.example.ITBook.batch;

import com.example.ITBook.common.enums.UserStatus;
import com.example.ITBook.user.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.junit4.SpringRunner;


import java.time.LocalDateTime;
import java.util.Date;

import javax.transaction.Transactional;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;


@Transactional
@RunWith(SpringRunner.class)
@SpringBootTest
public class InactiveUserJobTest {
	
	@Autowired private JobLauncherTestUtils jobLauncherTestUtils;
	
	@Autowired private UserRepository userRepository;

    @Test
    public void 휴면_회원_전환_테스트() throws Exception {

    	//JobExecution jobExecution = jobLauncherTestUtils.launchJob();

        Date nowDate = new Date();

        JobExecution jobExecution = jobLauncherTestUtils.launchJob(
                new JobParametersBuilder()
                        .addDate("nowDate",nowDate)
                        .toJobParameters());

    	assertThat(jobExecution.getStatus(),is(BatchStatus.COMPLETED));
    	
    	//업데이트 날짜가 1년전 and User 상태값이 ACTIVE인 사용자 find
        int size = userRepository.findByUpdatedDateBeforeAndStatusEquals(LocalDateTime.now().minusYears(1), UserStatus.ACTIVE)
                    .size();

        assertThat(size,is(0));

    }

}
