package com.example.ITBook.common.domain;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.example.ITBook.common.domain.pk.MyBasketPK;

import lombok.Getter;
import lombok.NoArgsConstructor;


/*
 * 장바구니 테이블
 * */

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
	@MapsId("user_no")
	@JoinColumn(name = "user_no")
	private User user;
	
	public MyBasket(Book book,User user) {
		this.myBasketPK = new MyBasketPK(book.getIsbn(),user.getUser_no());
		this.book = book;
		this.user = user;
		
	}
}
