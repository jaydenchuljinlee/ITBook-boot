package com.example.ITBook.common.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.ITBook.common.domain.pk.CategoryPK;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
@Entity
@Table(name = "tag")
public class Tag {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private long code;
	
	@Column(columnDefinition = "VARCHAR", length = 50)
	private String name;
	
	public Tag(long code) {
		this.code = code;
	}
	
	@Builder
	public Tag(long code,String name) {
		this.code = code;
		this.name = name;
	}

}
