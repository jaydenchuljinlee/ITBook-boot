package com.example.ITBook.myPage.paymentList.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ITBook.book.repository.BookRepository;
import com.example.ITBook.common.domain.Book;
import com.example.ITBook.common.domain.PayInfo;
import com.example.ITBook.common.domain.Payment;
import com.example.ITBook.common.domain.PaymentInformation;
import com.example.ITBook.common.domain.User;
import com.example.ITBook.common.domain.pk.PaymentInformationPK;
import com.example.ITBook.common.exception.DoNotUpdateOrInsertException;
import com.example.ITBook.common.exception.OveredBookQuantityException;
import com.example.ITBook.common.exception.PamentSizeException;
import com.example.ITBook.myPage.paymentList.repository.PayInfoRepository;
import com.example.ITBook.myPage.paymentList.repository.PaymentRepository;
import com.example.ITBook.user.repository.UserRepository;

/*
* 결제 관련 Service
* */
@Slf4j
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
	public List<PaymentInformation> insertpayInfo(Payment payment,PayInfo payInfo, User user) throws Exception {

		log.info("PaymentServiceImpl.insertpayInfo :::");

		List<PaymentInformation> paymentInfoList = new ArrayList<PaymentInformation>();//결제 정보를 저장하기 위한 리스트
		
		List<Book> list		= new ArrayList<Book>();//책 정보를 처리하기 위한 리스트
		
		checkPayment(list,payInfo);// 결제 건수, 재고 유무 처리
		
		user.setMileage(payInfo.getTotalMil());
		payment.setUser(user);
		
		paymentRepository.save(payment);//결제 저장
		
		if (!paymentRepository.existsById(payment.getPay_no())) throw new DoNotUpdateOrInsertException();// 결제가 제대로 이뤄지지 않았을 경우 Exception
		
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

		log.info("PaymentServiceImpl.selectList :::");

		return paymentRepository.findByUser(User.builder()
												.userNo(user_no)
												.build());
	}
	
	/*
	 * 다중 결제정보 처리
	 * @param : list(재고 리스트), payInfo(결제 정보 리스트, payment(결제 테이블),paymentInfoList(리턴 객체))
	 * */
	private void paymentInfoSaveInRepository(PayInfo payInfo, Payment payment, List<Book> list,List<PaymentInformation> paymentInfoList) {

		log.info("PaymentServiceImpl.paymentInfoSaveInRepository :::");

		for (int i = 0,loop = payInfo.getIsbn().size(); i < loop; i++) {//결제 정보를 하나씩 가져와 저장

			PaymentInformationPK pk = PaymentInformationPK.builder()
														.isbn(list.get(i).getIsbn())
														.payNo(payment.getPay_no())
														.build();
			
			int quantity = payInfo.getQuantity().get(i);//해당 정보의 수량

			//결제 정보
			PaymentInformation paymentInformation = PaymentInformation.builder()
																		.PK(pk)
																		.payment(payment)
																		.book(list.get(i))
																		.quantity(quantity)
																		.build();
			
			paymentInfoList.add(payInfoRepository.save(paymentInformation));
		}
		
	}

	/*
	 * 결제 가능 상태 체크
	 * @param : list(재고 리스트), payInfo(결제 정보 리스트)
	 * */
	private void checkPayment(List<Book> list,PayInfo payInfo) {

		log.info("PaymentServiceImpl.checkPayment :::");

		int length = payInfo.getIsbn().size();//결제 정보의 갯수
		
		if (length == 0) throw new PamentSizeException();//결제 처리를 찾을 수 없음
		
		List<Book> original =  bookRepository.findAllById(payInfo.getIsbn());//재고
		
		for(int i = 0; i < length; i++) {// 결제 정보 리스트 분기문 체크
			
			long isbn 		= payInfo.getIsbn().get(i);
			
			Book book = Book.builder()
							.isbn(isbn)
							.quantity(payInfo.getQuantity().get(i))
							.build();
			
			int currentCnt	= payInfo.getQuantity().get(i);//현재 요청 구매량
			int originalCnt = original.get(original.indexOf(book)).getQuantity();//재고량
			
			if (originalCnt < currentCnt) //재고 범위 초과
				throw new OveredBookQuantityException(currentCnt, originalCnt);
			
			list.add(book);
		}
	}

	

}
