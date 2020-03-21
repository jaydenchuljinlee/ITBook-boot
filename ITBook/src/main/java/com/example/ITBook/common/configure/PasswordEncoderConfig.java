package com.example.ITBook.common.configure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class PasswordEncoderConfig {

	@Bean(name = "passwordencoder")
	public PasswordEncoder passwordencoder() {
		
		return new BCryptPasswordEncoder();
		
	}
}
