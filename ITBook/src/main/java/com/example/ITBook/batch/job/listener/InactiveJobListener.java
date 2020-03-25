package com.example.ITBook.batch.job.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.stereotype.Component;

/*
* 휴면 유저 Job의 요청 전/후를 처리할 Listener
* */

@Slf4j
@Component
public class InactiveJobListener implements JobExecutionListener {
    @Override
    public void beforeJob(JobExecution jobExecution) {
        log.info("before job");
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        log.info("after job");
    }
}
