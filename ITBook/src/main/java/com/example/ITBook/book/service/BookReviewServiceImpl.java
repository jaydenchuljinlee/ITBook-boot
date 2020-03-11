package com.example.ITBook.book.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
	 * @info	: å ���� ��� �޼���
	 * @var		: pk(���� Ű ��ü), book(å ��ü), user(ȸ�� ��ü), review(���� ��ü)
	 * @return	: ��� ����
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
		
		return true;
	}

	/*
	 * @info	: å ���� ��� �޼���
	 * @var		: pk(���� Ű ��ü), book(å ��ü), user(ȸ�� ��ü), review(���� ��ü)
	 * @return	: ��� ����
	 * */
	@Override
	public void updateBookReview(Review review, long isbn, Long idx) {

		ReviewPK pk = new ReviewPK(isbn,idx);
		
		Book book = new Book(isbn);
		User user = new User(idx);
		
		review.setBook(book);
		review.setUser(user);
		review.setReviewPK(pk);
		
		bookReviewRepository.delete(review);
		bookReviewRepository.save(review);
		
	}

	/*
	 * @info	: å ���� ��� �޼���
	 * @var		: pk(���� Ű ��ü), book(å ��ü), user(ȸ�� ��ü), review(���� ��ü)
	 * @return	: ��� ����
	 * */
	@Override
	public void deleteBookReview(Review review, long isbn, Long idx) {

		ReviewPK pk = new ReviewPK(isbn,idx);
		
		Book book = new Book(isbn);
		User user = new User(idx);
		
		review.setBook(book);
		review.setUser(user);
		review.setReviewPK(pk);
		
		bookReviewRepository.delete(review);
		
	}

}
