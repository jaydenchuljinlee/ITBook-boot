package com.example.ITBook.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
@Entity
public class Scategory {

	@Id
	private long code;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "bcode")
	private Bcategory bcategory;
	
	private String name;
	
	@Builder
	public Scategory(long code,Bcategory bcategory) {
		this.code = code;
		this.bcategory = bcategory;
	}
	
	public Scategory(long code,Bcategory bcategory,String name) {
		this.code = code;
		this.bcategory = bcategory;
		this.name = name;
	}
}
