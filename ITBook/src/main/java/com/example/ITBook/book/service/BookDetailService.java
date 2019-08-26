package com.example.ITBook.book.service;

import java.util.Optional;

import com.example.ITBook.domain.Book;

public interface BookDetailService {

	Optional<Book> selectOneBook(Long isbn) throws Exception;

}
