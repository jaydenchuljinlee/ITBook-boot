package com.example.ITBook.common.domain;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import com.example.ITBook.common.domain.pk.CategoryPK;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Entity
public class Hashtag {

	@EmbeddedId
	private CategoryPK pk;
	
	@ManyToOne
	@MapsId("isbn")
	@JoinColumn(name = "isbn")
	private Book book;
	
	@ManyToOne
	@MapsId("code")
	@JoinColumn(name = "code")
	private Tag tag;
	
	public Hashtag(Book book,Tag tag) {
		this.pk = new CategoryPK(book.getIsbn(),tag.getCode());
		this.book = book;
		this.tag = tag;
	}
}
