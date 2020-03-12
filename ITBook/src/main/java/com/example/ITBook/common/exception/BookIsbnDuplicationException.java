package com.example.ITBook.common.exception;

import lombok.Getter;

/*
 * å isbn �ߺ� ���� Ŭ����
 * */
@Getter
public class BookIsbnDuplicationException extends RuntimeException{

	private String isbn;
	
	public BookIsbnDuplicationException(String isbn) {
		this.isbn = isbn;
	}
}
