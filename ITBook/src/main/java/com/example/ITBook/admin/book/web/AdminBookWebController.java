package com.example.ITBook.admin.book.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.ITBook.admin.book.service.AdminBookService;
import com.example.ITBook.common.domain.Book;

@Controller
@SessionAttributes("sessionId")
@RequestMapping(value = "/admin/book")
public class AdminBookWebController {
	
	@Autowired
	private AdminBookService adminBookService;

	/*
	 * @param 	:  model
	 * @return	: 관리자 책 관리 메인 페이지
	 */
	@GetMapping(value= "/")
	public String adminBookMain(Model model) throws Exception {
		
		List<Book> list = adminBookService.selectAllBooks();
		
		model.addAttribute("adminBookList", list);
		
		return "book/bookManage.adminTiles";
	}
	
	
	
}
