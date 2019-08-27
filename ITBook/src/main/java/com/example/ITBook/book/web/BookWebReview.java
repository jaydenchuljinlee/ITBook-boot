package com.example.ITBook.book.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.ITBook.book.service.BookReviewService;
import com.example.ITBook.domain.Review;

@Controller
public class BookWebReview {
	private static final Logger logger = LoggerFactory.getLogger(BookWebReview.class);
	private BookReviewService bookReviewService;
	
	public BookWebReview(BookReviewService bookReviewService) {
		this.bookReviewService = bookReviewService;
	}
	

	@RequestMapping(value = "bookReview",method = RequestMethod.POST)
	public String bookReview(@ModelAttribute Review review
			,@RequestParam long isbn
			,@RequestParam long idx
			,Model model) throws Exception {
		
		boolean check = bookReviewService.insertBookReview(review,isbn,idx);
		
		return "redirect:book";
	}
}
