package com.example.ITBook.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@Getter
@Entity
public class Book {

	@Id
	private Long isbn;
	
	private int price;
	private int page;
	private int bCategory;
	private int sCategory;
	private int quantity;
	
	private String bImage;
	private String bTheme;
	private String original;
	private String publish;
	private String bAuthor;
	private String translator;
	
	private LocalDateTime publishDate;
	
	@Column(columnDefinition = "TEXT")
	private String bIntro;
	@Column(columnDefinition = "TEXT")
	private String bContents;
	@Column(columnDefinition = "TEXT")
	private String bAuthorInfo;
	
	
	public Book(Long isbn,int price,int page,int bCategory,int sCategory,int quantity,String bImage,String bTheme
			,String original,String publish,String bAuthor,String translator,LocalDateTime publishDate
			,String bIntro,String bContents,String bAuthorInfo) {
		
		this.isbn = isbn;
		this.price = price;
		this.page = page;
		this.bCategory = bCategory;
		this.sCategory = sCategory;
		this.quantity = quantity;
		this.bImage = bImage;
		this.bTheme = bTheme;
		this.original = original;
		this.publish = publish;
		this.bAuthor = bAuthor;
		this.translator = translator;
		this.publishDate = publishDate;
		this.bIntro = bIntro;
		this.bContents = bContents;
		this.bAuthorInfo = bAuthorInfo;
		
	}
	
	
}
