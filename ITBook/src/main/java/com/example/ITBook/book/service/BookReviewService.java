package com.example.ITBook.book.service;

import com.example.ITBook.common.domain.Review;

public interface BookReviewService {

	boolean insertBookReview(Review review, long isbn, long idx) throws Exception;

	void updateBookReview(Review review, long isbn, Long idx);

	void deleteBookReview(Review review, long isbn, Long idx);

}
