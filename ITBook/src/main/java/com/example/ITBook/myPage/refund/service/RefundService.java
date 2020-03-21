package com.example.ITBook.myPage.refund.service;

import java.util.Optional;

import com.example.ITBook.common.domain.Payment;
import com.example.ITBook.common.domain.PaymentInformation;

public interface RefundService {

	public boolean updatePaymentStateOnRefund(long pay_no, long user_no) throws Exception;
}
