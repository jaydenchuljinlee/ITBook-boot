package com.example.ITBook.myPage.myBasket.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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

@Service
public class MyBasketServiceImpl implements MyBasketService {
	private static final Logger logger = LoggerFactory.getLogger(MyBasketServiceImpl.class);
	
	@Autowired
	private MyBasketRepository myBasketRepository;
	
	@Override
	public boolean deleteMyBasket(long isbn, User user_param) throws Exception {

		HashMap<String ,Object> map = new HashMap<>();
		
		Book book = new Book(isbn);
		User user = new User(user_param.getUserNo());
		
		MyBasket myBasket = new MyBasket(book,user);
			
		return myBasketRepository.remove(myBasket) == 1 ? true : false;
	}
	
	@Override
	public List<MyBasket> selectByUser(Long index) throws Exception {
		
		return myBasketRepository.findAllByUser(new User(index));
	}
	
	@Override
	public boolean insertMyBasket(long isbn,long userIdx) throws Exception {
		
		Optional<MyBasket> chk = checkForExistence(isbn,userIdx);
		
		if(chk.isPresent()) throw new DuplicatedMyBasketException(isbn);
		
		return insertMyBasketInDB(isbn,userIdx);
	}

	private Optional<MyBasket> checkForExistence(long isbn, long idx) {
		MyBasketPK pk = new MyBasketPK(isbn,idx);
		
		return myBasketRepository.findById(pk);
	}

	private boolean insertMyBasketInDB(long isbn, long idx) throws Exception{
		Book book = new Book(isbn);
		
		User user = new User(idx);
		
		MyBasket myBasket = new MyBasket(book,user);
		
		myBasketRepository.save(myBasket);	
		
		return myBasketRepository.existsById(myBasket.getMyBasketPK());
	}

	

	

}
