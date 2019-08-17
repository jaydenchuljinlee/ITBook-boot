package com.example.ITBook.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Entity
public class Book {

	@Id
	private Long ISBN;
	
	private int PRICE;
	private int PAGE;
	private int B1_BCATEGORY;
	private int B1_SCATEGORY;
	private int B2_BCATEGORY;
	private int B2_SCATEGORY;
	private int QUANTITY;
	
	private String B_IMAGE;
	private String B_THEME;
	private String ORIGINAL;
	private String PUBLISH;
	private String B_AUTHOR;
	private String TRANSLATOR;
	
	private LocalDateTime PUBLISH_DATE;
	
	@Column(columnDefinition = "TEXT")
	private String B_INTRO;
	@Column(columnDefinition = "TEXT")
	private String B_CONTENTS;
	@Column(columnDefinition = "TEXT")
	private String B_AUTHORINFO;
	
	
}
