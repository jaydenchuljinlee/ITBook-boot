package com.example.ITBook.common.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.example.ITBook.common.domain.pk.ReviewPK;

import lombok.*;

/*
 * 책 리뷰 테이블
 * */

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "review")
public class Review  implements Serializable{

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ReviewPK reviewPK;
	
	@ManyToOne
	@MapsId("isbn")
	@JoinColumn(name = "isbn")
	private Book book;
	
	@ManyToOne
	@MapsId("user_no")
	@JoinColumn(name = "user_no")
	private User user;
	
	@Column(name = "career",columnDefinition = "INT",length = 11)
	private int career;
	@Column(name = "star",columnDefinition = "INT",length = 11)
	private int star;
	
	@Column(name = "title",columnDefinition = "VARCHAR",length = 50)
	private String title;
	
	@Column(name = "created_date",columnDefinition = "DATETIME")
	private LocalDateTime createdDate;
	
	@Column(name = "updated_date",columnDefinition = "DATETIME")
	private LocalDateTime updatedDate;
	
	@Column(name = "contents",columnDefinition="TEXT")
	private String contents;

	
}
