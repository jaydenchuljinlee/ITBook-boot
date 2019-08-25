package com.example.ITBook.book.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.ITBook.book.service.BookService;
import com.example.ITBook.domain.Book;

@Controller
public class BookWebController {
	
	private BookService bookService;
	
	public BookWebController(BookService bookService) {
		this.bookService = bookService;
	}

	@RequestMapping(value = "/book")
	public String book(Model model) throws Exception {
		
		List<Book> list = bookService.selectBookListAll();
		
		model.addAttribute("bookList", list);
		
		return "newBook.book-main";
	}
	
	@RequestMapping(value = "/recommendBook")
	public String recommendBook() throws Exception {
		
		return "recommendBook.book-main";
	}
}
