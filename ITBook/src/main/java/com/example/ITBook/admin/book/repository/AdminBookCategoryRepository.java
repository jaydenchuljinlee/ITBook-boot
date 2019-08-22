package com.example.ITBook.admin.book.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import com.example.ITBook.domain.Bookcategory;
import com.example.ITBook.domain.Book;
import com.example.ITBook.domain.BookCategoryPK;

public interface AdminBookCategoryRepository extends JpaRepository<Bookcategory, BookCategoryPK>{

	@Modifying
	@Transactional
	void deleteByBook(Book book);

	
}
