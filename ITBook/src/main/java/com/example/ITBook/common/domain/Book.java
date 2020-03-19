package com.example.ITBook.common.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
 * 책 정보 DB 테이블
 * */
@NoArgsConstructor
@Setter
@Getter
@Entity
public class Book {

	@Id
	@Column(columnDefinition = "BIGINT",length = 21)
	private Long isbn;
	
	@Column(columnDefinition = "INT",length = 11)
	private int price;
	@Column(columnDefinition = "INT",length = 11)
	private int page;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "scode")
	private Scategory s_category;
	
	@Size(max = 11)
	private int quantity;
	
	@Column(columnDefinition = "VARCHAR",length = 50)
	private String image;
	@Column(columnDefinition = "VARCHAR",length = 50)
	private String theme;
	@Column(columnDefinition = "VARCHAR",length = 50)
	private String original;
	@Column(columnDefinition = "VARCHAR",length = 50)
	private String publish;
	@Column(columnDefinition = "VARCHAR",length = 50)
	private String author;
	@Column(columnDefinition = "VARCHAR",length = 50)
	private String translator;
	
	@Column(columnDefinition = "DATETIME")
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
