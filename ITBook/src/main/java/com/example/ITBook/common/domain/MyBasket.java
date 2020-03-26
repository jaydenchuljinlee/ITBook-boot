package com.example.ITBook.common.domain;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.example.ITBook.common.domain.pk.MyBasketPK;

import lombok.*;


/*
 * 장바구니 테이블
 * */

@Builder
@NoArgsConstructor @AllArgsConstructor
@Data
@Entity
@Table(name = "mybasket")
public class MyBasket  implements Serializable{

	private static final long serialVersionUID = 1L;
	
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
}
