package com.example.ITBook.book.service;

import java.util.Optional;

import com.example.ITBook.common.domain.Review;

public interface BookReviewService {

	Optional<Review> insertBookReview(Review review, long isbn, long idx) throws Exception;

	Optional<Review> updateBookReview(Review review, long isbn, Long idx)throws Exception;

	Optional<Review> deleteBookReview(Review review, long isbn, Long idx)throws Exception;

}
