package com.example.ITBook.book.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ITBook.domain.Book;
import com.example.ITBook.domain.Review;
import com.example.ITBook.domain.pk.ReviewPK;

@Repository
public interface BookReviewRepository extends JpaRepository<Review, ReviewPK>{

	List<Review> findByBook(Book book)throws Exception;

}
