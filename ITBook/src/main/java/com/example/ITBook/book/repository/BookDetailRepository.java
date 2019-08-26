package com.example.ITBook.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ITBook.domain.Book;

public interface BookDetailRepository extends JpaRepository<Book, Long>{

}
