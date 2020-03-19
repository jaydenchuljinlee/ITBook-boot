package com.example.ITBook.myPage.paymentList.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ITBook.common.domain.Book;
import com.example.ITBook.common.domain.PayInfo;
import com.example.ITBook.common.domain.Payment;
import com.example.ITBook.common.domain.PaymentInformation;
import com.example.ITBook.common.domain.User;
import com.example.ITBook.myPage.paymentList.repository.PayInfoRepository;
import com.example.ITBook.myPage.paymentList.repository.PaymentRepository;
import com.example.ITBook.user.repository.UserRepository;

@Service
public class PaymentServiceImpl implements PaymentService {
	
	@Autowired
	private PaymentRepository paymentRepository;
	@Autowired
	private PayInfoRepository payInfoRepository;

	/*
	 * 결제
	 * @param 	: payment(결제 객체), payInfo(결제정보-다중구매 리스트)
	 * @return	: 
	 * @throws	: exception
	 * */
	@Transactional
	@Override
	public List<PaymentInformation> insertpayInfo(Payment payment,PayInfo payInfo, HttpSession session) throws Exception {

		List<PaymentInformation> paymentInfoList = new ArrayList<PaymentInformation>();
		List<Book> list = new ArrayList<Book>();
		
		int length = payInfo.getIsbn().size();
		
		for(int i = 0; i < length; i++) {
			
			Book book = new Book();
			
			book.setIsbn(payInfo.getIsbn().get(i));
			book.setQuantity(payInfo.getQuantity().get(i));
			
			list.add(book);
		}
		
		User user = ((User) session.getAttribute("user"));
		user.setMileage(payInfo.getTotalMil());
		payment.setUser(user);
		
		paymentRepository.save(payment);
		
		for (int i = 0; i < length; i++) {
			
			int quantity = payInfo.getQuantity().get(i);
			
			PaymentInformation paymentInformation = new PaymentInformation(payment,list.get(i),quantity);
			
			paymentInfoList.add(payInfoRepository.save(paymentInformation));
		}
		
		return paymentInfoList;
	}

}
