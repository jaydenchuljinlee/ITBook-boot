package com.example.ITBook.book.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.ITBook.book.service.BookReviewService;
import com.example.ITBook.domain.Review;
import com.example.ITBook.domain.User;

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
			,HttpSession session
			,Model model) throws Exception {
		
		boolean check = bookReviewService.insertBookReview(review,isbn,((User) session.getAttribute("user")).getIdx());
		
		return "redirect:bookDetail?isbn="+isbn;
	}
}
