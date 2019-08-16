package com.example.ITBook.main.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainWebController {

	@RequestMapping(value = "/main")
	public String main() throws Exception {
		
		return "main-tiles";
	}
}
