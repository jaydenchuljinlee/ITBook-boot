package com.example.ITBook.common.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.*;

/*
 * ���� ī�װ� ���̺�
 * */

@Builder
@NoArgsConstructor @AllArgsConstructor
@Data
@Entity
@Table(name = "bcategory")
public class Bcategory  implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	private long code;
	
	private String name;

}
