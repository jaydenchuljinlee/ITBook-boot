package com.example.ITBook.book.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ITBook.book.repository.BookDetailRepository;
import com.example.ITBook.book.repository.BookReviewRepository;
import com.example.ITBook.common.domain.Book;
import com.example.ITBook.common.domain.Review;

@Service
public class BookDetailServiceImpl implements BookDetailService {
	
	@Autowired
	private BookDetailRepository bookDetailRepository;
	@Autowired
	private BookReviewRepository bookReviewRepository;

	@Override
	public Optional<Book> selectOneBook(Long isbn) throws Exception {
		
		return bookDetailRepository.findById(isbn);
	}

	/*
	 * @var 	: book(√• ∞¥√º), rvList(∏Æ∫‰ ∏ÆΩ∫∆Æ), grade(∆Ú¡°), length(∏Æ∫‰ ªÁ¿Ã¡Ó), rtnMap(∏Æ∫‰¡§∫∏)
	 * @return	: ∏Æ∫‰ ¡§∫∏ ∏ 
	 *  */
	@Override
	public Map<String, Object> selectReviewList(Long isbn) throws Exception {
		
		Book book = new Book(isbn);
		
		List<Review> rvList = bookReviewRepository.findByBook(book);
		
		int grade	= 0;
		int length	= rvList.size(); 
		
		Map<String, Object> rtnMap = new HashMap<String, Object>();
		
		for (Review rv : rvList) grade += rv.getStar();
		
		grade /= length;
		
		rtnMap.put("grade", grade);
		rtnMap.put("length", length);
		rtnMap.put("rvList", rvList);
		
		return rtnMap;
	}

}
