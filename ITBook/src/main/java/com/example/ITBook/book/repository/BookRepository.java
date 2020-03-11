package com.example.ITBook.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ITBook.common.domain.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{

}
