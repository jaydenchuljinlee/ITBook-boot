package com.example.ITBook.book.service;

import java.util.List;

import com.example.ITBook.common.domain.Book;

public interface BookService {

	List<Book> selectBookListAll() throws Exception;

	List<Book> selectNewBookList() throws Exception;

	List<Book> selectBestBookList() throws Exception;

}
