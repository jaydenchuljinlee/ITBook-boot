package com.example.ITBook.common.domain.pk;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.NoArgsConstructor;


/*
 * �ؽ��±� ����Ű PK ��ü
 * */

@NoArgsConstructor
@Getter
@Embeddable
public class HashtagePK {
	private static final long serialVersionUID = 1L;
	
	@Column(name = "isbn")
	private long isbn;
	
	@Column(name = "code")
	private long code;
	
	public HashtagePK(long isbn) {
		this.isbn = isbn;
	}
	
	public HashtagePK(long isbn,long code) {
		this.isbn = isbn;
		this.code = code;
	}
	
}
