package com.example.ITBook.domain.pk;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import com.example.ITBook.domain.Tag;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Embeddable
public class CategoryPK implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Column(name = "isbn")
	private long isbn;
	
	@Column(name = "code")
	private long code;
	
	public CategoryPK(long isbn,long code) {
		this.isbn = isbn;
		this.code = code;
	}
}
