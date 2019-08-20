package com.example.ITBook.domain;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import lombok.Getter;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Getter
@Entity
public class BookCategory {
	
	@EmbeddedId
	private BookCategoryPK pk;
	
	@ManyToOne
	@MapsId("isbn")
	@JoinColumn(name = "isbn")
	private Book book;
	
	@ManyToOne
	@MapsId("scode")
	@JoinColumn(name = "scode")
	private Scategory scategory;
	
	public BookCategory(Book book,Scategory scategory) {
		this.pk = new BookCategoryPK(book.getIsbn(),scategory.getCode());
		this.book = book;
		this.scategory = scategory;
	}
	
}
