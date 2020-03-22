package com.example.ITBook.myPage.paymentList.service;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import com.example.ITBook.common.domain.PayInfo;
import com.example.ITBook.common.domain.Payment;
import com.example.ITBook.common.domain.PaymentInformation;
import com.example.ITBook.common.domain.User;

public interface PaymentService {

	List<PaymentInformation> insertpayInfo(Payment payment,PayInfo payInfo, User user) throws Exception;

	List<PaymentInformation> selectList(Long user_no) throws Exception;


}
