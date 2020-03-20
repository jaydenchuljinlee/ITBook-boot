package com.example.ITBook.myPage.paymentList.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ITBook.book.repository.BookRepository;
import com.example.ITBook.common.domain.Book;
import com.example.ITBook.common.domain.PayInfo;
import com.example.ITBook.common.domain.Payment;
import com.example.ITBook.common.domain.PaymentInformation;
import com.example.ITBook.common.domain.User;
import com.example.ITBook.common.exception.DoNotUpdateOrInsertException;
import com.example.ITBook.common.exception.OveredBookQuantityException;
import com.example.ITBook.common.exception.PamentSizeException;
import com.example.ITBook.myPage.paymentList.repository.PayInfoRepository;
import com.example.ITBook.myPage.paymentList.repository.PaymentRepository;
import com.example.ITBook.user.repository.UserRepository;

@Service
public class PaymentServiceImpl implements PaymentService {
	
	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private PaymentRepository paymentRepository;
	@Autowired
	private PayInfoRepository payInfoRepository;

	/*
	 * 결제
	 * @param 	: payment(결제 객체), payInfo(결제정보-다중구매 리스트)
	 * @return	: 
	 * @throws	: exception, PamentSizeException(결제 처리 0), OveredBookQuantityException(재고 범위 초과)
	 * */
	@Transactional
	@Override
	public List<PaymentInformation> insertpayInfo(Payment payment,PayInfo payInfo, HttpSession session) throws Exception {

		List<PaymentInformation> paymentInfoList = new ArrayList<PaymentInformation>();
		
		List<Book> list		= new ArrayList<Book>();
		
		checkPayment(list,payInfo);// 결제 건수, 재고 유무 처리
		
		User user = ((User) session.getAttribute("user"));
		user.setMileage(payInfo.getTotalMil());
		payment.setUser(user);
		
		if (!paymentRepository.insert(payment).isPresent()) throw new DoNotUpdateOrInsertException();
		
		paymentInfoSaveInRepository(payInfo,payment,list,paymentInfoList);// 결제 정보 리스트 insert
		
		return paymentInfoList;
	}
	
	/*
	 * 결제
	 * @param 	: user_no(유저 번호)
	 * @return	: 결제 리스트
	 * @throws	: exception
	 * */
	@Override
	public List<PaymentInformation> selectList(Long user_no) throws Exception {
		
		return payInfoRepository.findAllByUserNo(user_no);
	}
	
	/*
	 * 다중 결제정보 처리
	 * @param : list(재고 리스트), payInfo(결제 정보 리스트, payment(결제 테이블),paymentInfoList(리턴 객체))
	 * */
	private void paymentInfoSaveInRepository(PayInfo payInfo, Payment payment, List<Book> list,List<PaymentInformation> paymentInfoList) {

		for (int i = 0,loop = payInfo.getIsbn().size(); i < loop; i++) {
			
			int quantity = payInfo.getQuantity().get(i);
			
			PaymentInformation paymentInformation = new PaymentInformation(payment,list.get(i),quantity);
			
			paymentInfoList.add(payInfoRepository.save(paymentInformation));
		}
		
	}

	/*
	 * 결제 가능 상태 체크
	 * @param : list(재고 리스트), payInfo(결제 정보 리스트)
	 * */
	private void checkPayment(List<Book> list,PayInfo payInfo) {

		int length = payInfo.getIsbn().size();
		
		if (length == 0) throw new PamentSizeException();//결제 처리를 찾을 수 없음
		
		List<Book> original =  bookRepository.findByIsbn(payInfo.getIsbn());//재고
		
		for(int i = 0; i < length; i++) {// 결제 정보 리스트 분기문 체크 
			
			Book book = new Book();
			
			long isbn 		= payInfo.getIsbn().get(i);
			int currentCnt	= payInfo.getQuantity().get(i);
			int originalCnt = original.get(original.indexOf(new Book(isbn))).getQuantity();
			
			if (originalCnt < currentCnt) //재고 범위 초과
				throw new OveredBookQuantityException(currentCnt, originalCnt);
			
			book.setIsbn(payInfo.getIsbn().get(i));
			book.setQuantity(payInfo.getQuantity().get(i));
			
			list.add(book);
		}
	}

	

}
