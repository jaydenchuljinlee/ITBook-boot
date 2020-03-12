package com.example.ITBook.common.exception;

import lombok.Getter;

/*
 * Ä¿³Ø¼Ç ¿¡·¯
 * */
@Getter
public class FailedConnectionException extends RuntimeException{

	private String url;
	
	public FailedConnectionException(String url) {
		this.url = url;
	}
}
