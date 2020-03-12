package com.example.ITBook.common.exception;

import lombok.Getter;

/*
 * 책 isbn 중복 예외 클래스
 * */
@Getter
public class BookIsbnDuplicationException extends RuntimeException{

	private String isbn;
	
	public BookIsbnDuplicationException(String isbn) {
		this.isbn = isbn;
	}
}
