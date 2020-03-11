package com.example.ITBook.book.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.ITBook.book.service.BookService;
import com.example.ITBook.common.domain.Book;

@Controller
@RequestMapping("/book")
public class BookWebController {
	private static final Logger logger = LoggerFactory.getLogger(BookWebController.class);
	
	@Autowired
	private BookService bookService;

	/*
	 * @info	: å ���� ������
	 * @param 	: model
	 * @return	: å ���� ������
	 */
	@RequestMapping(value = "/")
	public String book(Model model) {
		
		try {
			
			List<Book> list = bookService.selectBookListAll();
			
			model.addAttribute("bookList", list);
			
		} catch(Exception e) {
			
			logger.error(e.getMessage());
			throw new RuntimeException();
		}
		
		return "contents/newBook.book-main";
	}
	
	/*
	 * @info	: ��õ å ������
	 * @param 	: model
	 * @return	: ��õ å ������
	 */
	@RequestMapping(value = "/recommendBook")
	public String recommendBook(Model model) {
		
		try {
			
			List<Book> list = bookService.selectBestBookList();
			
			model.addAttribute("bookList", list);
			
		} catch(Exception e) {
			
			logger.error(e.getMessage());
			
			throw new RuntimeException();
		}
		
		return "contents/recommendBook.book-main";
	}
}
