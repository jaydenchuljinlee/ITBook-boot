package com.example.ITBook.book.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookWebController {

	@RequestMapping(value = "/book")
	public String book() throws Exception {
		
		return "newBook.book-main";
	}
	
	@RequestMapping(value = "/recommendBook")
	public String recommendBook() throws Exception {
		
		return "recommendBook.book-main";
	}
}
