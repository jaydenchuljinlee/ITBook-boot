package com.example.ITBook.common.exception;

import lombok.Getter;

@Getter
public class DuplicatedMyBasketException extends RuntimeException{

	private long isbn;
	
	public DuplicatedMyBasketException(long isbn) {
		this.isbn = isbn;
	}
}
