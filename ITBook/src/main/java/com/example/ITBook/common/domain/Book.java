package com.example.ITBook.common.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.*;
import javax.validation.constraints.Size;

import lombok.*;

/*
 * 책 정보 DB 테이블
 * */
@NoArgsConstructor @AllArgsConstructor @Builder
@Data @EqualsAndHashCode(callSuper = false)
@Entity @Table(name = "book")
public class Book  implements Serializable{

	private static final long serialVersionUID = 1L;
	
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
}
