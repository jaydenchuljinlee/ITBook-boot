package com.example.ITBook.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class BookCategoryPK implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Column(name = "isbn")
	private long isbn;
	
	@Column(name = "scode")
	private long scode;
	
	public BookCategoryPK(long isbn,long scode) {
		this.isbn = isbn;
		this.scode = scode;
	}

}
