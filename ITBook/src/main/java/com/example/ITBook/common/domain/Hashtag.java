package com.example.ITBook.common.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.example.ITBook.common.domain.pk.HashtagePK;

import lombok.*;

/*
 * 해시태그 객체
 * */

@Builder
@NoArgsConstructor @AllArgsConstructor
@Data
@Entity
@Table(name = "hashtag")
public class Hashtag  implements Serializable{

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private HashtagePK pk;// 해시태그 복합 키 객체
	
	@ManyToOne
	@MapsId("isbn")
	@JoinColumn(name = "isbn")
	private Book book;
	
	@ManyToOne
	@MapsId("code")
	@JoinColumn(name = "code")
	private Tag tag;
}
