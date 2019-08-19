package com.example.ITBook.domain;

import java.time.LocalDateTime;

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
	@MapsId("sCode")
	@JoinColumn(name = "sCode")
	private SCategory sCategory;
	
	public BookCategory(Book book,SCategory sCategory) {
		this.pk = new BookCategoryPK(book.getIsbn(),sCategory.getCode(),LocalDateTime.now());
	}
	
}
