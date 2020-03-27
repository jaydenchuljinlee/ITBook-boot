package com.example.ITBook.myPage.payment;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.ITBook.common.domain.Book;
import com.example.ITBook.common.domain.PayInfo;
import com.example.ITBook.common.domain.Payment;
import com.example.ITBook.common.domain.User;
import com.example.ITBook.myPage.paymentList.service.PaymentService;

import lombok.extern.slf4j.Slf4j;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.Test;

@Transactional
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class PaymentResigetTest {

	@Autowired private PaymentService paymentService;
	
	@Rollback
	@Test
	public void 결제_등록_테스트() throws Exception {
		
		log.info("PaymentResigetTest.결제_등록_테스트 :::");
		
		long userNo = Long.parseLong("0");
		long isbn1  = Long.parseLong("1234567890");
		long isbn2  = Long.parseLong("12345678901234567");
		
		User user = User.builder()
						.userNo(userNo).build();
		
		Payment payment = Payment.builder()
								.user(user).build();
		
		List<Long> bookList			= new ArrayList<>();
		List<Integer> quantityList	= new ArrayList<>();
		
		bookList.add(isbn1);
		bookList.add(isbn2);
		
		quantityList.add(10);
		quantityList.add(20);
		
		PayInfo payInfo = PayInfo.builder()
								.isbn(bookList)
								.quantity(quantityList)
								.build();
		
		assertThat(paymentService.insertpayInfo(payment, payInfo, user).size(),is(2));
	}
}
