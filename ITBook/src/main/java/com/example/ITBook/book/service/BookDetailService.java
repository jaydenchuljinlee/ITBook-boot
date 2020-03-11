package com.example.ITBook.book.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.example.ITBook.common.domain.Book;
import com.example.ITBook.common.domain.Review;

public interface BookDetailService {

	Optional<Book> selectOneBook(Long isbn) throws Exception;

	Map<String, Object> selectReviewList(Long isbn) throws Exception;

}
