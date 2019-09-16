package com.example.ITBook.admin.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ITBook.domain.Book;

public interface AdminBookRepository extends JpaRepository<Book, Long>{

	
}
