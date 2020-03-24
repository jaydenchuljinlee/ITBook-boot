package com.example.ITBook.main.web;

import java.util.List;

import com.example.ITBook.common.annotation.Session;
import com.example.ITBook.common.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.ITBook.book.service.BookService;
import com.example.ITBook.common.domain.Book;

@Controller
@SessionAttributes("user")
public class MainWebController {
	
	private BookService bookService;
	
	public MainWebController(BookService bookService) {
		this.bookService = bookService;
	}

	@RequestMapping(value = "/main")
	public String main(Model model) throws Exception {
		
		List<Book> newBookList = bookService.selectNewBookList();
		
		List<Book> BestBookList = bookService.selectBestBookList();

		model.addAttribute("newBookList",newBookList);
		model.addAttribute("BestBookList",BestBookList);
		
		return "main-tiles";
	}
}
