package com.example.ITBook.book.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.example.ITBook.book.repository.BookReviewRepository;
import com.example.ITBook.common.domain.Book;
import com.example.ITBook.common.domain.Review;
import com.example.ITBook.common.domain.User;
import com.example.ITBook.common.domain.pk.ReviewPK;

@Service
public class BookReviewServiceImpl implements BookReviewService {
	private static final Logger logger = LoggerFactory.getLogger(BookReviewServiceImpl.class);
	
	@Autowired
	private BookReviewRepository bookReviewRepository;
	
	/*
	 * @info	: Ã¥ ¸®ºä µî·Ï ¸Þ¼­µå
	 * @var		: pk(¸®ºä Å° °´Ã¼), book(Ã¥ °´Ã¼), user(È¸¿ø °´Ã¼), review(¸®ºä °´Ã¼)
	 * @return	: µî·Ï ¿©ºÎ
	 * */
	@Override
	public boolean insertBookReview(Review review, long isbn, long idx) throws Exception {
		
		ReviewPK pk = new ReviewPK(isbn,idx);
		
		Book book = new Book(isbn);
		User user = new User(idx);
		
		review.setBook(book);
		review.setUser(user);
		review.setReviewPK(pk);
		
		bookReviewRepository.save(review);
		
		return bookReviewRepository.existsById(pk);
	}

	/*
	 * @info	: Ã¥ ¸®ºä µî·Ï ¸Þ¼­µå
	 * @var		: pk(¸®ºä Å° °´Ã¼), book(Ã¥ °´Ã¼), user(È¸¿ø °´Ã¼), review(¸®ºä °´Ã¼)
	 * @return	: µî·Ï ¿©ºÎ
	 * */
	@Override
	public boolean updateBookReview(Review review, long isbn, Long idx) throws Exception{

		ReviewPK pk = new ReviewPK(isbn,idx);
		
		Book book = new Book(isbn);
		User user = new User(idx);
		
		review.setBook(book);
		review.setUser(user);
		review.setReviewPK(pk);
		
		return bookReviewRepository.update(review) == 1 ? true : false;
		
	}

	/*
	 * @info	: Ã¥ ¸®ºä µî·Ï ¸Þ¼­µå
	 * @var		: pk(¸®ºä Å° °´Ã¼), book(Ã¥ °´Ã¼), user(È¸¿ø °´Ã¼), review(¸®ºä °´Ã¼)
	 * @return	: µî·Ï ¿©ºÎ
	 * */
	@Override
	public boolean deleteBookReview(Review review, long isbn, Long idx) throws Exception{

		ReviewPK pk = new ReviewPK(isbn,idx);
		
		Book book = new Book(isbn);
		User user = new User(idx);
		
		review.setBook(book);
		review.setUser(user);
		review.setReviewPK(pk);
		
		//bookReviewRepository.delete(review);
		
		
		return bookReviewRepository.remove(review) == 1 ? true : false;
	}

}
