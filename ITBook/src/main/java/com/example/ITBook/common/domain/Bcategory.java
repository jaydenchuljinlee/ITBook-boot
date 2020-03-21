package com.example.ITBook.common.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.example.ITBook.common.domain.Scategory.ScategoryBuilder;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/*
 * 상위 카테고리 테이블
 * */

@NoArgsConstructor
@Getter
@Entity
public class Bcategory  implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	private long code;
	
	private String name;
	
	public Bcategory(long code) {
		this.code = code;
	}
	
	@Builder
	public Bcategory(long code,String name) {
		this.code = code;
		this.name = name;
	}
}
