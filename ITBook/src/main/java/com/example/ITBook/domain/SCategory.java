package com.example.ITBook.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "scategory")
public class SCategory {

	@Id
	private long code;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private BCategory bCategory;
	
	private String name;
}
