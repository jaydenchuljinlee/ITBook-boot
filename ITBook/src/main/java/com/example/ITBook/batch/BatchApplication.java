package com.example.ITBook.batch;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


//EnableBatchProcessing 통해 자동 등록된 Bean인 JobBuilderFactory, StepBuilderFactory를 InactiveUserConfig에 주입할 수 있다.
@EnableBatchProcessing
@SpringBootApplication(scanBasePackages = {"com.example.ITBook"})
public class BatchApplication {
	
	public static void main(String[] args) {
        SpringApplication.run(BatchApplication.class, args);
    }
}
