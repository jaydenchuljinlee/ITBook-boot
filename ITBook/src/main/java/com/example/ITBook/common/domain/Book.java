package com.example.ITBook.common.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
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
public class Book {

	@Id
	private Long isbn;
	
	private int price;
	private int page;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "scode")
	private Scategory s_category;
	
	private int quantity;
	
	private String image;
	private String theme;
	private String original;
	private String publish;
	private String author;
	private String translator;
	
	private LocalDateTime publishdate;
	
	@Column(columnDefinition = "TEXT")
	private String intro;
	@Column(columnDefinition = "TEXT")
	private String contents;
	@Column(columnDefinition = "TEXT")
	private String authorinfo;
	
	public Book(Long isbn) {
		this.isbn = isbn;
	}
	
	@Builder
	public Book(Long isbn,int price,int page,Scategory s_category,int quantity,String image,String theme
			,String original,String publish,String author,String translator,LocalDateTime publishdate
			,String intro,String contents,String authorinfo) {
		
		this.isbn = isbn;
		this.price = price;
		this.page = page;
		this.s_category = s_category;
		this.quantity = quantity;
		this.image = image;
		this.theme = theme;
		this.original = original;
		this.publish = publish;
		this.author = author;
		this.translator = translator;
		this.publishdate = LocalDateTime.now();
		this.intro = intro;
		this.contents = contents;
		this.authorinfo = authorinfo;
		
	}
	
	
}
