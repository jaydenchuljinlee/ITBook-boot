package com.example.ITBook.common.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.*;

/*
* 환불 테이블
* */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "refund")
public class Refund  implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idx;
	
	@ManyToOne(fetch =  FetchType.LAZY)
	@JoinColumn(name ="pay_no")
    private Payment payment;
	
	@Column(name = "state",columnDefinition = "INT",length = 11)
	private int state;
}
