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
	@Query(value = "insert into Review values(:#{#review})",nativeQuery = false)
	Optional<Review> insert(@Param("review") Review review) throws Exception;
	
	@Modifying
	@Transactional
	@Query(value = "Update review rv from review rv where rv.isbn = :#{#review.isbn} and rv.user_no = :#{#review.user_no}",nativeQuery = false)
	Optional<Review> update(@Param("review") Review review) throws Exception;
	
	@Modifying
	@Transactional
	@Query(value = "delete from Review rv where rv.user_no = :#{#review.user_no} and rv.isbn = :#{#review.isbn}",nativeQuery = false)
	Optional<Review> remove(@Param("review") Review review) throws Exception;

}
