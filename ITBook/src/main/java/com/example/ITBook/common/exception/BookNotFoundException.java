package com.example.ITBook.common.exception;

import lombok.Getter;

/*
 * Ã¥ °´Ã¼ Not Found ¿¹¿Ü
 * */
@Getter
public class BookNotFoundException extends RuntimeException{

	long isbn;
	
	public BookNotFoundException(long isbn) {
		this.isbn = isbn;
	}
	
}
