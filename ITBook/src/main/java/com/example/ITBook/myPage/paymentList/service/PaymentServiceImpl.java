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
	 * ����
	 * @param 	: payment(���� ��ü), payInfo(��������-���߱��� ����Ʈ)
	 * @return	: 
	 * @throws	: exception, PamentSizeException(���� ó�� 0), OveredBookQuantityException(��� ���� �ʰ�)
	 * */
	@Transactional
	@Override
	public List<PaymentInformation> insertpayInfo(Payment payment,PayInfo payInfo, HttpSession session) throws Exception {

		List<PaymentInformation> paymentInfoList = new ArrayList<PaymentInformation>();
		
		List<Book> list		= new ArrayList<Book>();
		
		checkPayment(list,payInfo);// ���� �Ǽ�, ��� ���� ó��
		
		User user = ((User) session.getAttribute("user"));
		user.setMileage(payInfo.getTotalMil());
		payment.setUser(user);
		
		if (!paymentRepository.insert(payment).isPresent()) throw new DoNotUpdateOrInsertException();
		
		paymentInfoSaveInRepository(payInfo,payment,list,paymentInfoList);// ���� ���� ����Ʈ insert
		
		return paymentInfoList;
	}
	
	/*
	 * ����
	 * @param 	: user_no(���� ��ȣ)
	 * @return	: ���� ����Ʈ
	 * @throws	: exception
	 * */
	@Override
	public List<PaymentInformation> selectList(Long user_no) throws Exception {
		
		return payInfoRepository.findAllByUserNo(user_no);
	}
	
	/*
	 * ���� �������� ó��
	 * @param : list(��� ����Ʈ), payInfo(���� ���� ����Ʈ, payment(���� ���̺�),paymentInfoList(���� ��ü))
	 * */
	private void paymentInfoSaveInRepository(PayInfo payInfo, Payment payment, List<Book> list,List<PaymentInformation> paymentInfoList) {

		for (int i = 0,loop = payInfo.getIsbn().size(); i < loop; i++) {
			
			int quantity = payInfo.getQuantity().get(i);
			
			PaymentInformation paymentInformation = new PaymentInformation(payment,list.get(i),quantity);
			
			paymentInfoList.add(payInfoRepository.save(paymentInformation));
		}
		
	}

	/*
	 * ���� ���� ���� üũ
	 * @param : list(��� ����Ʈ), payInfo(���� ���� ����Ʈ)
	 * */
	private void checkPayment(List<Book> list,PayInfo payInfo) {

		int length = payInfo.getIsbn().size();
		
		if (length == 0) throw new PamentSizeException();//���� ó���� ã�� �� ����
		
		List<Book> original =  bookRepository.findByIsbn(payInfo.getIsbn());//���
		
		for(int i = 0; i < length; i++) {// ���� ���� ����Ʈ �б⹮ üũ 
			
			Book book = new Book();
			
			long isbn 		= payInfo.getIsbn().get(i);
			int currentCnt	= payInfo.getQuantity().get(i);
			int originalCnt = original.get(original.indexOf(new Book(isbn))).getQuantity();
			
			if (originalCnt < currentCnt) //��� ���� �ʰ�
				throw new OveredBookQuantityException(currentCnt, originalCnt);
			
			book.setIsbn(payInfo.getIsbn().get(i));
			book.setQuantity(payInfo.getQuantity().get(i));
			
			list.add(book);
		}
	}

	

}
