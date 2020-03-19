package com.example.ITBook.common.domain.pk;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Embeddable
public class MyBasketPK  implements Serializable{

	private static final long serialVersionUID = 1L;

	@Column(name = "isbn")
	private long isbn;
	
	@Column(name = "user_no")
	private long user_no;
	
	public MyBasketPK(long isbn,long user_no) {
		this.isbn = isbn;
		this.user_no = user_no;
	}
	
}
