package com.example.ITBook.common.domain;

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

import com.example.ITBook.common.domain.User.UserBuilder;
import com.example.ITBook.common.enums.SocialType;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/*
 * 결제 테이블
 * */

@Getter @Setter @NoArgsConstructor @Builder
@Entity
@Table(name = "payment")
public class Payment {

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
	
	public Payment(long pay_no, User user) {
		this.pay_no = pay_no;
		this.user = user;
		
	}
	
	public Payment(long pay_no,User user,int totalPrice,int totalquantity,int state,LocalDateTime payDate
			,String name,String phone,String call,String message,String address1,String address2
			,String address3,String method,int mileage) {
		this.pay_no = pay_no;
		this.user = user;
		this.totalPrice = totalPrice;
		this.totalquantity = totalquantity;
		this.state = state;
		this.payDate = payDate;
		this.name = name;
		this.phone = phone;
		this.call = call;
		this.message = message;
		this.address1 = address1;
		this.address2 = address2;
		this.address3 = address3;
		this.method = method;
		this.mileage = mileage;
	}
}
