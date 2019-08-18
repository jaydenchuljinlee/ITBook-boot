package com.example.ITBook.admin.book.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminBookWebController {

	@RequestMapping(value= "adminBookMain")
	public String adminBookMain() throws Exception {
		
		return "book/bookManage.adminTiles";
	}
	
	@RequestMapping(value= "adminBookDetail")
	public String adminBookDetail() throws Exception {
		
		return "book/bookDetail.adminTiles";
	}
}
