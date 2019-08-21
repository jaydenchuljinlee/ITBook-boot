package com.example.ITBook.admin.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ITBook.domain.Bookcategory;
import com.example.ITBook.domain.BookCategoryPK;

public interface AdminBookCategoryRepository extends JpaRepository<Bookcategory, BookCategoryPK>{

	
}
