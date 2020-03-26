package com.example.ITBook.common.domain.pk;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.*;

/*
 * 카테고리 복합키 PK 객체
 * */

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Embeddable
public class CategoryPK implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Column(name = "isbn")
	private long isbn;
	
	@Column(name = "code")
	private long code;

}
