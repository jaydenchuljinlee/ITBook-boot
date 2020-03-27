package com.example.ITBook.myPage.refund;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.ITBook.common.domain.Payment;
import com.example.ITBook.common.domain.Refund;
import com.example.ITBook.common.domain.User;
import com.example.ITBook.myPage.refund.service.RefundService;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class RefundRequestTest {

	@Autowired private RefundService refundService;
	
	@Test
	public void ȯ��_��û_�׽�Ʈ() throws Exception{
		
		log.info("RefundRequestTest.ȯ��_��û_�׽�Ʈ :::");
		
		long userNo = Long.parseLong("0");
		long payNo  = Long.parseLong("1");
		
		assertThat(refundService.updatePaymentStateOnRefund(payNo, userNo),is(true));
	}
}
