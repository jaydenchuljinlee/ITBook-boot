package com.example.ITBook.common.configure;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableTransactionManagement
public class DataSourceConfig {

	@Bean
	public DataSource createDataSource(DataSourceProperties properties) {
		
		HikariDataSource datasource = new HikariDataSource();
		
		datasource.setJdbcUrl(properties.getUrl());
		datasource.setUsername(properties.getUsername());
		datasource.setPassword(properties.getPassword());
		datasource.setDriverClassName(properties.getDriverClassName());
		
		return datasource;
	}
	
}
