package com.example.ITBook.myPage.paymentList.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.example.ITBook.common.domain.PayInfo;
import com.example.ITBook.common.domain.Payment;
import com.example.ITBook.common.domain.PaymentInformation;

public interface PaymentService {

	List<PaymentInformation> insertpayInfo(Payment payment,PayInfo payInfo, HttpSession session) throws Exception;


}
