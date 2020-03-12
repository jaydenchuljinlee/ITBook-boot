package com.example.ITBook.common.exception;

import lombok.Getter;

/*
 * Ŀ�ؼ� ����
 * */
@Getter
public class FailedConnectionException extends RuntimeException{

	private String url;
	
	public FailedConnectionException(String url) {
		this.url = url;
	}
}
