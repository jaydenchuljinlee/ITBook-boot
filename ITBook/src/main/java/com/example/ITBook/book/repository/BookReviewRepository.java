package com.example.ITBook.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ITBook.domain.Review;
import com.example.ITBook.domain.pk.ReviewPK;

public interface BookReviewRepository extends JpaRepository<Review, ReviewPK>{

}
