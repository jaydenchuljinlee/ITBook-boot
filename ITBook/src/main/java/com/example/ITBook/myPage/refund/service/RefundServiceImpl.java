package com.example.ITBook.myPage.refund.service;

import java.util.Optional;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ITBook.common.domain.Payment;
import com.example.ITBook.common.domain.PaymentInformation;
import com.example.ITBook.myPage.paymentList.repository.PaymentRepository;

/*
* ȯ�� ���� Service
* */
@Slf4j
@Service
public class RefundServiceImpl implements RefundService {

	@Autowired
	private PaymentRepository paymentRepository;
	
	/*
	 * ����
	 * @param 	: pay_no(���� ��ȣ), user_no(ȸ�� ��ȣ)
	 * @return	: optional<PaymentInformation> (���� ����)
	 * @throws	: exception
	 * */
	@Override
	public boolean updatePaymentStateOnRefund(long pay_no, long user_no) throws Exception {

		log.info("RefundServiceImpl.refundRequest :::");

		return paymentRepository.updatePaymentStateOnFalse(pay_no, user_no) == 1 ? true : false;
	}
}
