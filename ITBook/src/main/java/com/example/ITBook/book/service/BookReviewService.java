package com.example.ITBook.book.service;

import com.example.ITBook.domain.Review;

public interface BookReviewService {

	boolean insertBookReview(Review review, long isbn, long idx) throws Exception;

}
