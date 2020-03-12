package com.example.ITBook.common.exception;

import lombok.Getter;

/*
 * å ��ü Not Found ����
 * */
@Getter
public class BookNotFoundException extends RuntimeException{

	long isbn;
	
	public BookNotFoundException(long isbn) {
		this.isbn = isbn;
	}
	
}
