package com.example.ITBook.admin.book.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.ITBook.admin.book.service.AdminBookService;
import com.example.ITBook.domain.Book;

@Controller
public class AdminBookWebController {
	
	private AdminBookService adminBookService;
	
	public AdminBookWebController(AdminBookService adminBookService) {
		this.adminBookService = adminBookService;
	}

	@RequestMapping(value= "adminBookMain")
	public String adminBookMain(Model model) throws Exception {
		
		List<Book> list = adminBookService.selectAllBooks();
		
		model.addAttribute("adminBookList", list);
		
		return "book/bookManage.adminTiles";
	}
	
	
	
}
