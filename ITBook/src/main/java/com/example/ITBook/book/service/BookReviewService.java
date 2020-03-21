package com.example.ITBook.book.service;

import java.util.Optional;

import com.example.ITBook.common.domain.Review;

public interface BookReviewService {

	boolean insertBookReview(Review review, long isbn, long idx) throws Exception;

	boolean updateBookReview(Review review, long isbn, Long idx)throws Exception;

	boolean deleteBookReview(Review review, long isbn, Long idx)throws Exception;

}
