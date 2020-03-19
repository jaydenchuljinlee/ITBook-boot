package com.example.ITBook.book.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.ITBook.common.domain.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{

	@Modifying
    @Transactional
    @Query(value = "select b from book b order by publishdate desc limit 1,7",nativeQuery = false)
    List<Book> seleteNewbookList();
	
	@Modifying
    @Transactional
    @Query(value = "select payInfo.book from PaymentInformation payInfo GROUP BY payInfo.book ORDER BY count(payInfo.book) DESC limit 1,7",nativeQuery = false)
    List<Book> seleteBestbookList();
	
	List<Book> findByIsbn(List<Long> book);
}
