package com.example.ITBook.common.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.example.ITBook.common.domain.pk.PaymentInformationPK;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "pay_info")
public class PaymentInformation {
	
	@EmbeddedId
	private PaymentInformationPK PK;
	
	@ManyToOne
	@MapsId("pay_no")
	@JoinColumn(name = "pay_no")
	private Payment payment;
	
	@ManyToOne
	@MapsId("isbn")
	@JoinColumn(name = "isbn")
	private Book book;
	
	private int quantity;
	
	public PaymentInformation(Payment payment,Book book,int quantity) {
		this.PK = new PaymentInformationPK(payment.getIdx(),book.getIsbn());
		this.payment = payment;
		this.book = book;
		this.quantity = quantity;
	}
	
	
}
