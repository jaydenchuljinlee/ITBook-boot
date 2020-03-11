package com.example.ITBook.common.domain.pk;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Embeddable
public class PaymentInformationPK implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Column(name = "pay_no")
	private long payNo;
	
	@Column(name = "isbn")
	private long isbn;
	
	
	public PaymentInformationPK(long payNo,long isbn) {
		this.payNo = payNo;
		this.isbn = isbn;
	}
	
	
}
