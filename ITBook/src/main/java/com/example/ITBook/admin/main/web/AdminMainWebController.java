package com.example.ITBook.admin.main.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("user")
@RequestMapping("/admin")
public class AdminMainWebController {

	@RequestMapping(value ="/main")
	public String adminMain() throws Exception {
		
		return "main/main.adminTiles";
	}
	
	
}
