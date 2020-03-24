package com.example.ITBook.batch.config;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.batch.test.JobLauncherTestUtils;

@Configuration
@EnableBatchProcessing// spring boot batch starter�� �̸� ���ǵ� �������� ����
public class TestJobConfig {

    //JobLauncherTestUtils : ��ġ�� job�� ������ �׽�Ʈ�ϴ� ��ƿ Ŭ����
    @Bean
    public JobLauncherTestUtils jobLauncherTestUtils() {
        return new JobLauncherTestUtils();
    }
}
