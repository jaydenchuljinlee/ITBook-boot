package com.example.ITBook.common.exception;

import lombok.Getter;

/*
 * å ���� ���� �ʰ�
 * */

@Getter
public class OveredBookQuantityException extends RuntimeException{

	private int current;
	private int database;
	
	public OveredBookQuantityException(int current,int database) {
		this.current	= current;
		this.database	= database; 
	}
}
