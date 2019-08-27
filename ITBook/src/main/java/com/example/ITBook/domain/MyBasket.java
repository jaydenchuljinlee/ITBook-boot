package com.example.ITBook.domain;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.example.ITBook.domain.pk.MyBasketPK;

import lombok.Getter;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Getter
@Entity
@Table(name = "mybasket")
public class MyBasket {
	
	@EmbeddedId
	private MyBasketPK myBasketPK;
	
	@ManyToOne
	@MapsId("isbn")
	@JoinColumn(name = "isbn")
	private Book book;
	
	@ManyToOne
	@MapsId("idx")
	@JoinColumn(name = "idx")
	private User user;
	
	public MyBasket(Book book,User user) {
		this.myBasketPK = new MyBasketPK(book.getIsbn(),user.getIndex());
		this.book = book;
		this.user = user;
		
	}
}