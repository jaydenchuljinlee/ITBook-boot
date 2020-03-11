package com.example.ITBook.myPage.paymentList.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.example.ITBook.common.domain.Book;
import com.example.ITBook.common.domain.PayInfo;
import com.example.ITBook.common.domain.Payment;
import com.example.ITBook.common.domain.PaymentInformation;
import com.example.ITBook.common.domain.User;
import com.example.ITBook.myPage.paymentList.repository.PayInfoRepository;
import com.example.ITBook.myPage.paymentList.repository.PaymentRepository;
import com.example.ITBook.repository.UserRepository;

@Service
public class PaymentServiceImpl implements PaymentService {
	
	private PaymentRepository paymentRepository;
	private PayInfoRepository payInfoRepository;
	private UserRepository userRepository;
	
	public PaymentServiceImpl(PaymentRepository paymentRepository
			,PayInfoRepository payInfoRepository
			,UserRepository userRepository) {
		this.paymentRepository = paymentRepository;
		this.payInfoRepository = payInfoRepository;
		this.userRepository = userRepository;
	}

	@Override
	public List<PaymentInformation> insertpayInfo(Payment payment,PayInfo payInfo, HttpSession session) throws Exception {

		List<PaymentInformation> paymentInfoList = new ArrayList<PaymentInformation>();
		List<Book> list = new ArrayList<Book>();
		
		int length = payInfo.getIsbn().size();
		
		for(int i = 0; i < length; i++) {
			
			Book book = new Book();
			System.out.println(payInfo.getIsbn().get(i));
			book.setIsbn(payInfo.getIsbn().get(i));
			book.setQuantity(payInfo.getQuantity().get(i));
			
			list.add(book);
		}
		
		User user = ((User) session.getAttribute("user"));
		user.setMileage(payInfo.getTotalMil());
		payment.setUser(user);
		
		userRepository.save(user);
		paymentRepository.save(payment);
		
		for (int i = 0; i < length; i++) {
			
			int quantity = payInfo.getQuantity().get(i);
			
			PaymentInformation paymentInformation = new PaymentInformation(payment,list.get(i),quantity);
			
			paymentInfoList.add(payInfoRepository.save(paymentInformation));
		}
		
		return paymentInfoList;
	}

}
