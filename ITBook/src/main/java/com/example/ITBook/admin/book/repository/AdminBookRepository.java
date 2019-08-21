package com.example.ITBook.admin.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ITBook.domain.Book;

public interface AdminBookRepository extends JpaRepository<Book, Long>{

	
}
