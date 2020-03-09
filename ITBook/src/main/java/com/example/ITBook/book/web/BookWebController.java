package com.example.ITBook.book.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.ITBook.book.service.BookService;
import com.example.ITBook.domain.Book;

@Controller
@RequestMapping("/book")
public class BookWebController {
	
	@Autowired
	private BookService bookService;

	/*
	 * @param 	: model
	 * @return	: 책 메인 페이지
	 */
	@RequestMapping(value = "/")
	public String book(Model model) throws Exception {
		
		List<Book> list = bookService.selectBookListAll();
		
		model.addAttribute("bookList", list);
		
		return "contents/newBook.book-main";
	}
	
	/*
	 * @todo	: 별점이 높은 책을 선별해 보여주기
	 * @param 	: isbn(책 번호), session(세션), model
	 * @return	: 추천 책 페이지
	 */
	@RequestMapping(value = "/recommendBook")
	public String recommendBook() throws Exception {
		
		return "contents/recommendBook.book-main";
	}
}
