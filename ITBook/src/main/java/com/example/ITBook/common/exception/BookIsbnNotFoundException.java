package com.example.ITBook.common.exception;

import lombok.Getter;

/*
 * å isbn �ߺ� ���� Ŭ����
 * */
@Getter
public class BookIsbnNotFoundException extends RuntimeException{

private String isbn;
	
	public BookIsbnNotFoundException(String isbn) {
		this.isbn = isbn;
	}
}
