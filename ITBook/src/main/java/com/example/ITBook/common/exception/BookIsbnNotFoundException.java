package com.example.ITBook.common.exception;

import lombok.Getter;

/*
 * 책 isbn 중복 예외 클래스
 * */
@Getter
public class BookIsbnNotFoundException extends RuntimeException{

private String isbn;
	
	public BookIsbnNotFoundException(String isbn) {
		this.isbn = isbn;
	}
}
