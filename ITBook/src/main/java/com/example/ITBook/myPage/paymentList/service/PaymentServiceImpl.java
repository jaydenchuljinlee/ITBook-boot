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
* ���� ���� Service
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
	 * ����
	 * @param 	: payment(���� ��ü), payInfo(��������-���߱��� ����Ʈ)
	 * @return	: 
	 * @throws	: exception, PamentSizeException(���� ó�� 0), OveredBookQuantityException(��� ���� �ʰ�)
	 * */
	@Transactional
	@Override
	public List<PaymentInformation> insertpayInfo(Payment payment,PayInfo payInfo, User user) throws Exception {

		log.info("PaymentServiceImpl.insertpayInfo :::");

		List<PaymentInformation> paymentInfoList = new ArrayList<PaymentInformation>();//���� ������ �����ϱ� ���� ����Ʈ
		
		List<Book> list		= new ArrayList<Book>();//å ������ ó���ϱ� ���� ����Ʈ
		
		checkPayment(list,payInfo);// ���� �Ǽ�, ��� ���� ó��
		
		user.setMileage(payInfo.getTotalMil());
		payment.setUser(user);
		
		paymentRepository.save(payment);//���� ����
		
		if (!paymentRepository.existsById(payment.getPay_no())) throw new DoNotUpdateOrInsertException();// ������ ����� �̷����� �ʾ��� ��� Exception
		
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

		log.info("PaymentServiceImpl.selectList :::");

		return paymentRepository.findByUser(User.builder()
												.userNo(user_no)
												.build());
	}
	
	/*
	 * ���� �������� ó��
	 * @param : list(��� ����Ʈ), payInfo(���� ���� ����Ʈ, payment(���� ���̺�),paymentInfoList(���� ��ü))
	 * */
	private void paymentInfoSaveInRepository(PayInfo payInfo, Payment payment, List<Book> list,List<PaymentInformation> paymentInfoList) {

		log.info("PaymentServiceImpl.paymentInfoSaveInRepository :::");

		for (int i = 0,loop = payInfo.getIsbn().size(); i < loop; i++) {//���� ������ �ϳ��� ������ ����

			PaymentInformationPK pk = PaymentInformationPK.builder()
														.isbn(list.get(i).getIsbn())
														.payNo(payment.getPay_no())
														.build();
			
			int quantity = payInfo.getQuantity().get(i);//�ش� ������ ����

			//���� ����
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
	 * ���� ���� ���� üũ
	 * @param : list(��� ����Ʈ), payInfo(���� ���� ����Ʈ)
	 * */
	private void checkPayment(List<Book> list,PayInfo payInfo) {

		log.info("PaymentServiceImpl.checkPayment :::");

		int length = payInfo.getIsbn().size();//���� ������ ����
		
		if (length == 0) throw new PamentSizeException();//���� ó���� ã�� �� ����
		
		List<Book> original =  bookRepository.findAllById(payInfo.getIsbn());//���
		
		for(int i = 0; i < length; i++) {// ���� ���� ����Ʈ �б⹮ üũ
			
			long isbn 		= payInfo.getIsbn().get(i);
			
			Book book = Book.builder()
							.isbn(isbn)
							.quantity(payInfo.getQuantity().get(i))
							.build();
			
			int currentCnt	= payInfo.getQuantity().get(i);//���� ��û ���ŷ�
			int originalCnt = original.get(original.indexOf(book)).getQuantity();//���
			
			if (originalCnt < currentCnt) //��� ���� �ʰ�
				throw new OveredBookQuantityException(currentCnt, originalCnt);
			
			list.add(book);
		}
	}

	

}
