package com.example.ITBook.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.example.ITBook.domain.Scategory.ScategoryBuilder;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Entity
public class Bcategory {
	
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
