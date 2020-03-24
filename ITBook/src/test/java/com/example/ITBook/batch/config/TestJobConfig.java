package com.example.ITBook.batch.config;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.batch.test.JobLauncherTestUtils;

@Configuration
@EnableBatchProcessing// spring boot batch starter에 미리 정의된 설정들을 실행
public class TestJobConfig {

    //JobLauncherTestUtils : 배치의 job을 실행해 테스트하는 유틸 클래스
    @Bean
    public JobLauncherTestUtils jobLauncherTestUtils() {
        return new JobLauncherTestUtils();
    }
}
