package com.example.ITBook.book.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.ITBook.book.repository.BookReviewRepository;
import com.example.ITBook.domain.Book;
import com.example.ITBook.domain.Review;
import com.example.ITBook.domain.User;
import com.example.ITBook.domain.pk.ReviewPK;

@Service
public class BookReviewServiceImpl implements BookReviewService {
	private static final Logger logger = LoggerFactory.getLogger(BookReviewServiceImpl.class);
	private BookReviewRepository bookReviewRepository;
	
	public BookReviewServiceImpl(BookReviewRepository bookReviewRepository) {
		this.bookReviewRepository = bookReviewRepository;
	}
	
	@Override
	public boolean insertBookReview(Review review, long isbn, long idx) throws Exception {
		
		ReviewPK pk = new ReviewPK(isbn,idx);
		
		Optional<Review> chkisReview = bookReviewRepository.findById(pk);
		
		if (chkisReview.isPresent()) return false;
		
		Book book = new Book(isbn);
		User user = new User(idx);
		
		review.setBook(book);
		review.setUser(user);
		review.setReviewPK(pk);
		
		bookReviewRepository.save(review);
		
		return false;
	}

}
