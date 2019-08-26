package com.example.ITBook.myPage.myBasket.web;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.ITBook.domain.User;
import com.example.ITBook.myPage.myBasket.service.MyBasketService;

@Controller
public class MyBasketWebController {
	
	private MyBasketService myBasketService;
	
	public MyBasketWebController(MyBasketService myBasketService) {
		this.myBasketService = myBasketService;
	}

	@RequestMapping(value = "myBasket")
	public String mybascket(Model model) throws Exception {
		
		return "myPage/myBasket.myPage-tiles";
	}
	
	@RequestMapping(value = "addMyBasket")
	@ResponseBody
	public String addMyBasket(@RequestBody String param
			,HttpSession session
			,Model model) throws Exception {
		
		
		Optional<User> user = (Optional<User>) session.getAttribute("user");
		
		if (user.isPresent()) {
			
		}
		
		return "myPage/myBasket.myPage-tiles";
	}
}
