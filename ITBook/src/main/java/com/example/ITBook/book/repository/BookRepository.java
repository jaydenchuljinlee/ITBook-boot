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
	
	List<Book> findByIsbn(List<Long> book);
}
