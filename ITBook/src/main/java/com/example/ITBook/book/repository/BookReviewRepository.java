package com.example.ITBook.book.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.ITBook.common.domain.Book;
import com.example.ITBook.common.domain.Review;
import com.example.ITBook.common.domain.pk.ReviewPK;

@Repository
public interface BookReviewRepository extends JpaRepository<Review, ReviewPK>{

	List<Review> findByBook(Book book)throws Exception;
	
	@Modifying
	@Transactional
	@Query(value = "UPDATE Review SET career = :#{review.career}"
			+ " WHERE isbn = :#{#review.isbn} AND user_no = :#{#review.user_no}",nativeQuery = false)
	int update(@Param("review") Review review) throws Exception;

	@Modifying
	@Transactional
	@Query(value = "DELETE FROM Review WHERE isbn = :#{#review.isbn} AND user_no = :#{#review.user_no} ",nativeQuery = false)
	int remove(@Param("review") Review review) throws Exception;
}
