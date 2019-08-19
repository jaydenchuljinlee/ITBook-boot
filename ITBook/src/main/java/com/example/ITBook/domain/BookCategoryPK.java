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
	
	@Column(name = "sCode")
	private long sCode;
	
	@Column(name = "createdDate")
	private LocalDateTime createdDate;
	
	public BookCategoryPK(long isbn,long sCode,LocalDateTime createdDate) {
		this.isbn = isbn;
		this.sCode = sCode;
		this.createdDate = createdDate;
	}

}
