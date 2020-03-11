package com.example.ITBook.admin.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ITBook.common.domain.Book;

public interface AdminBookRegisterRepository extends JpaRepository<Book, Long>{

	
}
