package com.example.ITBook.main.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.ITBook.book.service.BookService;
import com.example.ITBook.domain.Book;

@Controller
public class MainWebController {
	
	private BookService bookService;
	
	public MainWebController(BookService bookService) {
		this.bookService = bookService;
	}
	
	@RequestMapping(value = "/main")
	public String main() throws Exception {
		
		List<Book> newBookList = bookService.selectNewBookList();
		
		List<Book> BestBookList = bookService.selectBestBookList();
		System.out.println(BestBookList);
		
		return "main-tiles";
	}
}
