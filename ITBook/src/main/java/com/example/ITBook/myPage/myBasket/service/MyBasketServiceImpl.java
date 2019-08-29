package com.example.ITBook.myPage.myBasket.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.ITBook.domain.Book;
import com.example.ITBook.domain.MyBasket;
import com.example.ITBook.domain.User;
import com.example.ITBook.domain.pk.MyBasketPK;
import com.example.ITBook.myPage.myBasket.repository.MyBasketRepository;

@Service
public class MyBasketServiceImpl implements MyBasketService {
	private static final Logger logger = LoggerFactory.getLogger(MyBasketServiceImpl.class);
	private MyBasketRepository myBasketRepository;
	
	public MyBasketServiceImpl(MyBasketRepository myBasketRepository) {
		this.myBasketRepository = myBasketRepository;
	}
	
	@Override
	public Map<String ,String> deleteMyBasket(long isbn, User user_param) throws Exception {

		Map<String ,String> map = new HashMap<String, String>();
		
		Book book = new Book(isbn);
		User user = new User(user_param.getIdx());
		
		MyBasket myBasket = new MyBasket(book,user);
		
		try {
			myBasketRepository.delete(myBasket);
			map.put("result", "success");
		} catch(Exception e) {
			logger.debug(e.getMessage());
		}
			
		return map;
	}
	
	@Override
	public List<MyBasket> selectByUser(Long index) throws Exception {
		
		
		return myBasketRepository.findAllByUser(new User(index));
	}
	
	@Override
	public boolean insertMyBasket(long isbn,long userIdx) throws Exception {
		
		Optional<MyBasket> chk = checkForExistence(isbn,userIdx);
		
		if(isPresent(chk)) return false;
		
		insertMyBasketInDB(isbn,userIdx);
		
		return true;
	}

	private boolean isPresent(Optional<MyBasket> chk) {
		
		return chk.isPresent();
	}

	private Optional<MyBasket> checkForExistence(long isbn, long idx) {
		MyBasketPK pk = new MyBasketPK(isbn,idx);
		
		return myBasketRepository.findById(pk);
	}

	private void insertMyBasketInDB(long isbn, long idx) {
		Book book = new Book(isbn);
		
		User user = new User(idx);
		
		MyBasket myBasket = new MyBasket(book,user);
		
		myBasketRepository.save(myBasket);	
		
	}

	

	

}
