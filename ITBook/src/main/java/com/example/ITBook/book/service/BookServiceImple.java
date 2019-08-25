package com.example.ITBook.book.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.ITBook.book.repository.BookRepository;
import com.example.ITBook.domain.Book;

@Service
public class BookServiceImple implements BookService {

	private BookRepository bookRepository;
	
	public BookServiceImple(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	
	@Override
	public List<Book> selectBookListAll() throws Exception {
		
		return bookRepository.findAll();
	}

}
