package com.example.ITBook;

import java.nio.charset.Charset;

import javax.servlet.Filter;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.filter.CharacterEncodingFilter;

//EnableBatchProcessing 통해 자동 등록된 Bean인 JobBuilderFactory, StepBuilderFactory를 InactiveUserConfig에 주입할 수 있다.
@EnableBatchProcessing
@Configuration
@SpringBootApplication(scanBasePackages = {"com.example.ITBook"})
public class ItBookApplication {

	public static void main(String[] args) {
		SpringApplication.run(ItBookApplication.class, args);
	}
	
	@Bean
    public HttpMessageConverter<String> responseBodyConverter() {
        return new StringHttpMessageConverter(Charset.forName("UTF-8"));
    }
 
    @Bean
    public Filter characterEncodingFilter() {
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);
        return characterEncodingFilter;
    }
}
