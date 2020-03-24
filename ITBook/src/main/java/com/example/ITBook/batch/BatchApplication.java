package com.example.ITBook.batch;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


//EnableBatchProcessing ���� �ڵ� ��ϵ� Bean�� JobBuilderFactory, StepBuilderFactory�� InactiveUserConfig�� ������ �� �ִ�.
@EnableBatchProcessing
@SpringBootApplication(scanBasePackages = {"com.example.ITBook"})
public class BatchApplication {
	
	public static void main(String[] args) {
        SpringApplication.run(BatchApplication.class, args);
    }
}
