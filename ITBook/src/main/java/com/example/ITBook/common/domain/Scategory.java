package com.example.ITBook.common.domain;

import java.io.Serializable;

import javax.persistence.*;

import lombok.*;

/*
 * 자식 카테고리 테이블
 * */

@Builder
@NoArgsConstructor @AllArgsConstructor
@Data
@Entity
@Table(name = "scategory")
public class Scategory  implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	private long code;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "bcode")
	private Bcategory bcategory;
	
	private String name;
}
