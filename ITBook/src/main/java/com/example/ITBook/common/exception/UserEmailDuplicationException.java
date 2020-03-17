package com.example.ITBook.common.exception;

import lombok.Getter;

@Getter
public class UserEmailDuplicationException extends RuntimeException{

	String email;
	
	public UserEmailDuplicationException(String email) {
		this.email = email;
	}
}
