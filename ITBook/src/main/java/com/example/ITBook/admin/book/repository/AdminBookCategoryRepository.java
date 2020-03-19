package com.example.ITBook.admin.book.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import com.example.ITBook.common.domain.Bookcategory;
import com.example.ITBook.common.domain.Book;
import com.example.ITBook.common.domain.pk.BookCategoryPK;

public interface AdminBookCategoryRepository extends JpaRepository<Bookcategory, BookCategoryPK>{

	@Modifying
	@Transactional
	void deleteByBook(Book book);

	
}
