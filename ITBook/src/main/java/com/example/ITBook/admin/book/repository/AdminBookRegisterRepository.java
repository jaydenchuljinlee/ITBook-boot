package com.example.ITBook.admin.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ITBook.domain.Book;

public interface AdminBookRegisterRepository extends JpaRepository<Book, Long>{

	
}
