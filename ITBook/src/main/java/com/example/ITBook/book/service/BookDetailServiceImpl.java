package com.example.ITBook.book.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.ITBook.book.repository.BookDetailRepository;
import com.example.ITBook.domain.Book;

@Service
public class BookDetailServiceImpl implements BookDetailService {
	
	private BookDetailRepository bookDetailRepository;
	
	public BookDetailServiceImpl(BookDetailRepository bookDetailRepository) {
		this.bookDetailRepository = bookDetailRepository;
	}

	@Override
	public Optional<Book> selectOneBook(Long isbn) throws Exception {
		
		return bookDetailRepository.findById(isbn);
	}

}
