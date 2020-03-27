package com.example.ITBook.myPage.myBasket.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ITBook.common.domain.Book;
import com.example.ITBook.common.domain.MyBasket;
import com.example.ITBook.common.domain.User;
import com.example.ITBook.common.domain.pk.MyBasketPK;
import com.example.ITBook.common.exception.DuplicatedMyBasketException;
import com.example.ITBook.myPage.myBasket.repository.MyBasketRepository;

/*
* ��ٱ��� ���� Service
* */
@Slf4j
@Service
public class MyBasketServiceImpl implements MyBasketService {
	
	@Autowired
	private MyBasketRepository myBasketRepository;

	/*
	* ��ٱ��� ���� ����
	* */
	@Override
	public boolean deleteMyBasket(long isbn, User user) throws Exception {

		log.info("MyBasketServiceImpl.deleteMyBasket :::");

		HashMap<String ,Object> map = new HashMap<>();
		
		Book book = Book.builder()
						.isbn(isbn)
						.build();
		
		MyBasket myBasket = MyBasket.builder()
									.book(book)
									.user(user)
									.build();
			
		return myBasketRepository.remove(myBasket) == 1 ? true : false;
	}

	/*
	* �ش� ȸ���� ��� �� ��� ��ٱ���
	* */
	@Override
	public List<MyBasket> selectByUser(Long index) throws Exception {

		log.info("MyBasketServiceImpl.selectByUser :::");
		
		return myBasketRepository.findAllByUser(User.builder()//��� ��ٱ��� ������ ������
													.userNo(index)
													.build());
	}

	/*
	* ��ٱ��� ���� insert
	* */
	@Override
	public boolean insertMyBasket(long isbn,long userIdx) throws Exception {

		log.info("MyBasketServiceImpl.insertMyBasket :::");

		Optional<MyBasket> chk = checkForExistence(isbn,userIdx);//��ٱ��� �ߺ� �˻�
		
		if(chk.isPresent()) throw new DuplicatedMyBasketException(isbn);// ��ٱ��� �ߺ� Exception
		
		return insertMyBasketInDB(isbn,userIdx);//���� ����
	}

	/*
	* ��ٱ��� ���� ����
	* */
	private Optional<MyBasket> checkForExistence(long isbn, long idx) {

		log.info("MyBasketServiceImpl.checkForExistence :::");

		MyBasketPK pk = new MyBasketPK(isbn,idx);// ��ٱ��� PK
		
		return myBasketRepository.findById(pk);//���� ����
	}

	/*
	* �����ͺ��̽��� ��ٱ��� ���� insert
	* */
	private boolean insertMyBasketInDB(long isbn, long idx) throws Exception{

		log.info("MyBasketServiceImpl.insertMyBasketInDB :::");

		Book book = Book.builder()
						.isbn(isbn)
						.build();// å ��ü
		
		User user = User.builder()
						.userNo(idx)
						.build();// ȸ�� ��ü
		
		MyBasket myBasket = MyBasket.builder()
									.book(book)
									.user(user)
									.build();// ��ٱ��� ���� ����
							
		myBasketRepository.save(myBasket);// ����
		
		return myBasketRepository.existsById(myBasket.getMyBasketPK());//���� ����
	}

	

	

}
