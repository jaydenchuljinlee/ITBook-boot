package com.example.ITBook.common.domain.pk;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.NoArgsConstructor;

/*
 * 책 카테고리 복합 키 객체
 * */

@NoArgsConstructor
@Getter
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
