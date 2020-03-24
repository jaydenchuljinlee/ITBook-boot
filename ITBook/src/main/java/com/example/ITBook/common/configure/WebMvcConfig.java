package com.example.ITBook.common.configure;

import com.example.ITBook.common.interceptor.JoinInterceptor;
import com.example.ITBook.common.resolver.UserArgumentResolver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;


/*
 * configurer
 * */
@EnableAutoConfiguration
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Autowired
    private UserArgumentResolver userArgumentResolver;

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(userArgumentResolver);
    }
    
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

    	registry.addInterceptor(new JoinInterceptor())
    			.addPathPatterns("/join/**")
    			.addPathPatterns("/login/**");
    }
}
