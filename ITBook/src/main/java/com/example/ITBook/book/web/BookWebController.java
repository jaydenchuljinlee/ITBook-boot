package com.example.ITBook.book.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.ITBook.book.service.BookService;
import com.example.ITBook.common.domain.Book;

import lombok.Getter;

@Controller
@SessionAttributes("user")
@RequestMapping(value = "/book")
public class BookWebController {
	private static final Logger logger = LoggerFactory.getLogger(BookWebController.class);
	
	@Autowired
	private BookService bookService;

	/*
	 * @info	: 책 메인 페이지
	 * @param 	: model
	 * @return	: 책 메인 페이지
	 */
	@GetMapping()
	public String book(Model model) throws Exception{
		
		List<Book> list = bookService.selectBookListAll();
		
		model.addAttribute("bookList", list);
		
		return "contents/newBook.book-main";
	}
	
	/*
	 * @info	: 추천 책 페이지
	 * @param 	: model
	 * @return	: 추천 책 페이지
	 */
	@RequestMapping(value = "/recommendBook")
	public String recommendBook(Model model) throws Exception{
		
		List<Book> list = bookService.selectBestBookList();
		
		model.addAttribute("bookList", list);
		
		return "contents/recommendBook.book-main";
	}
}
