package com.example.ITBook.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
@Entity
public class Tag {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private long code;
	
	private String name;
	
	public Tag(long code) {
		this.code = code;
	}
	
	@Builder
	public Tag(long code,String name) {
		this.code = code;
		this.name = name;
	}

}
