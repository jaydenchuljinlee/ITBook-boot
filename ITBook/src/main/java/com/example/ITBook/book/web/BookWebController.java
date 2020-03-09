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
	 * @return	: å ���� ������
	 */
	@RequestMapping(value = "/")
	public String book(Model model) throws Exception {
		
		List<Book> list = bookService.selectBookListAll();
		
		model.addAttribute("bookList", list);
		
		return "contents/newBook.book-main";
	}
	
	/*
	 * @todo	: ������ ���� å�� ������ �����ֱ�
	 * @param 	: isbn(å ��ȣ), session(����), model
	 * @return	: ��õ å ������
	 */
	@RequestMapping(value = "/recommendBook")
	public String recommendBook() throws Exception {
		
		return "contents/recommendBook.book-main";
	}
}
