package com.example.ITBook.book.service;

import java.util.List;

import com.example.ITBook.domain.Book;

public interface BookService {

	List<Book> selectBookListAll() throws Exception;

}