package com.example.ITBook.myPage.home.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyPageWebController {

	@RequestMapping(value = "myPage")
	public String myPage(Model model) throws Exception {
		
		return "myPage/myPage.myPage-tiles";
	}
	
}
