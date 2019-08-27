package com.example.ITBook.domain.pk;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Embeddable
public class ReviewPK  implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Column(name = "isbn")
	private long isbn;
	
	@Column(name = "idx")
	private long index;
	
	public ReviewPK(long isbn,long index) {
		this.isbn = isbn;
		this.index = index;
	}
}
