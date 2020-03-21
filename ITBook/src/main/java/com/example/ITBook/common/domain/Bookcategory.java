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
 * å ī�װ� ���̺�
 * */

@NoArgsConstructor
@Getter
@Entity
public class Bookcategory  implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private BookCategoryPK pk;// å ī�װ� ���� Ű ��ü
	
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
