package com.example.ITBook.admin.main.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminMainWebController {

	@RequestMapping(value ="adminMain")
	public String adminMain() throws Exception {
		
		return "main/main.adminTiles";
	}
	
	
}
