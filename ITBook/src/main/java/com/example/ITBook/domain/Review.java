package com.example.ITBook.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.example.ITBook.domain.pk.ReviewPK;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "review")
public class Review {

	@EmbeddedId
	private ReviewPK reviewPK;
	
	@ManyToOne
	@MapsId("isbn")
	@JoinColumn(name = "isbn")
	private Book book;
	
	@ManyToOne
	@MapsId("idx")
	@JoinColumn(name = "idx")
	private User user;
	
	private int career;
	private int star;
	
	private String title;
	
	@Column(name = "created_date")
	private LocalDateTime createdDate;
	
	@Column(name = "updated_date")
	private LocalDateTime updatedDate;
	
	@Column(columnDefinition="TEXT")
	private String contents;
	
	public Review(Book book,User user,int career,int star,String title,String contents) {
		this.reviewPK = new ReviewPK(book.getIsbn(),user.getIdx());
		this.book = book;
		this.user = user;
		this.career = career;
		this.star = star;
		this.title = title;
		this.contents = contents;
	}
	
}
