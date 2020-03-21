package com.example.ITBook.common.domain;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import com.example.ITBook.common.domain.pk.BookCategoryPK;

import lombok.Getter;
import lombok.NoArgsConstructor;

/*
 * 책 카테고리 테이블
 * */

@NoArgsConstructor
@Getter
@Entity
public class Bookcategory  implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private BookCategoryPK pk;// 책 카테고리 복합 키 객체
	
	@ManyToOne
	@MapsId("isbn")
	@JoinColumn(name = "isbn")
	private Book book;
	
	@ManyToOne
	@MapsId("scode")
	@JoinColumn(name = "scode")
	private Scategory scategory;
	
	public Bookcategory(Book book,Scategory scategory) {
		this.pk = new BookCategoryPK(book.getIsbn(),scategory.getCode());
		this.book = book;
		this.scategory = scategory;
	}
	
}
