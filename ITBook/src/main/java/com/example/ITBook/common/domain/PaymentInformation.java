package com.example.ITBook.common.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.example.ITBook.common.domain.pk.PaymentInformationPK;

import lombok.*;

/*
 * 결제 정보 테이블
 * */

@Builder
@NoArgsConstructor @AllArgsConstructor
@Data
@Entity
@Table(name = "pay_info")
public class PaymentInformation  implements Serializable{

	private static final long serialVersionUID = 1L;
	
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
	
	@Column(columnDefinition = "INT",length = 11)
	private int quantity;
	
	
}
