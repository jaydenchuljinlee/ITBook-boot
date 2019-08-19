package com.example.ITBook.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "bcategory")
public class BCategory {
	
	@Id
	private long code;
	
	String name;
	
	public BCategory(long code) {
		this.code = code;
	}
}
