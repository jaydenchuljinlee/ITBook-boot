package com.example.ITBook.common.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

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
 * 결제 테이블
 * */

@Builder
@NoArgsConstructor @AllArgsConstructor
@Data
@Entity
@Table(name = "payment")
public class Payment implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long pay_no;
	
	@ManyToOne(fetch =  FetchType.LAZY)
	@JoinColumn(name ="user_no")
    private User user;
	
	@Column(name = "price",length = 10)
	private int totalPrice;
	@Column(name = "quantity",length = 10)
	private int totalquantity;
	@Column(name = "state",length = 10)
	private int state;
	
	@Column(name = "pay_date",columnDefinition = "DATETIME")
	private LocalDateTime payDate;
	
	@Column(name = "name",columnDefinition = "VARCHAR",length = 50)
	private String name;
	@Column(name = "phone",columnDefinition = "VARCHAR",length = 50)
	private String phone;
	@Column(name = "house_phone",columnDefinition = "VARCHAR",length = 50)
	private String call;
	@Column(name = "message",columnDefinition = "VARCHAR",length = 50)
	private String message;
	@Column(name = "address_1",columnDefinition = "VARCHAR",length = 50)
	private String address1;
	@Column(name = "address_2",columnDefinition = "VARCHAR",length = 50)
	private String address2;
	@Column(name = "address_3",columnDefinition = "VARCHAR",length = 50)
	private String address3;
	@Column(name = "method",columnDefinition = "VARCHAR",length = 50)
	private String method;
	@Column(name = "apply_mileage",length = 10)
	private int mileage;

}
