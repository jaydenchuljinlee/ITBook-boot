package com.example.ITBook.book.web;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.ITBook.book.service.BookDetailService;
import com.example.ITBook.domain.Book;
import com.example.ITBook.domain.User;

@Controller
public class BookWebDetail {
	private static final Logger logger = LoggerFactory.getLogger(BookWebDetail.class);

	private BookDetailService bookDetailService;
	
	public BookWebDetail(BookDetailService bookDetailService) {
		this.bookDetailService = bookDetailService;
	}
	
	@RequestMapping(value = "bookDetail")
	private String bookDetail(@RequestParam Long isbn
			,HttpSession session
			,Model model) throws Exception {
		
		Optional<Book> book = bookDetailService.selectOneBook(isbn);
		
		model.addAttribute("book", book.get());
		model.addAttribute("userSession", ((User)session.getAttribute("user")).getIndex());
		
		return "book_detail/bookDetail.book-main";
	}
}
