package com.example.ITBook.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.example.ITBook.domain.User.UserBuilder;
import com.example.ITBook.enums.SocialType;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Entity
@Setter
@Getter
@NoArgsConstructor
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idx;
	
	@ManyToOne(fetch =  FetchType.LAZY)
	@JoinColumn(name ="user_no")
    private User user;
	
	@Column(name = "price")
	private int totalPrice;
	@Column(name = "quantity")
	private int totalquantity;
	@Column(name = "state")
	private int state;
	
	@Column(name = "pay_date")
	private LocalDateTime payDate;
	
	@Column(name = "name")
	private String name;
	@Column(name = "phone")
	private String phone;
	@Column(name = "house_phone")
	private String call;
	@Column(name = "message")
	private String message;
	@Column(name = "address_1")
	private String address1;
	@Column(name = "address_2")
	private String address2;
	@Column(name = "address_3")
	private String address3;
	@Column(name = "method")
	private String method;
	@Column(name = "apply_mileage")
	private int mileage;
	
	public Payment(long idx, User user) {
		this.idx = idx;
		this.user = user;
		
	}
	
	public Payment(long idx,User user,int totalPrice,int totalquantity,int state,LocalDateTime payDate
			,String name,String phone,String call,String message,String address1,String address2
			,String address3,String method,int mileage) {
		this.idx = idx;
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
