package com.example.ITBook.myPage.refund.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ITBook.common.domain.Payment;
import com.example.ITBook.common.domain.PaymentInformation;
import com.example.ITBook.myPage.paymentList.repository.PaymentRepository;

@Service
public class RefundServiceImpl implements RefundService {

	@Autowired
	private PaymentRepository paymentRepository;
	
	/*
	 * 결제
	 * @param 	: pay_no(결제 번호), user_no(회원 번호)
	 * @return	: optional<PaymentInformation> (성공 여부)
	 * @throws	: exception
	 * */
	@Override
	public Optional<Payment> updatePaymentStateOnRefund(long pay_no, long user_no) throws Exception {
		
		return paymentRepository.updatePaymentStateOnFalse(pay_no, user_no);
	}
}
