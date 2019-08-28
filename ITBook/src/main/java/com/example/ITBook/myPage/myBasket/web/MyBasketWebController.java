package com.example.ITBook.myPage.myBasket.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.ITBook.domain.MyBasket;
import com.example.ITBook.domain.User;
import com.example.ITBook.myPage.myBasket.service.MyBasketService;

@Controller
public class MyBasketWebController {
	private static final Logger logger = LoggerFactory.getLogger(MyBasketWebController.class);
	private MyBasketService myBasketService;
	
	public MyBasketWebController(MyBasketService myBasketService) {
		this.myBasketService = myBasketService;
	}

	@RequestMapping(value = "myBasket")
	public String mybascket(HttpSession session
			,Model model) throws Exception {
		
		List<MyBasket> list = myBasketService.selectByUser(((User)session.getAttribute("user")).getIndex());
		
		model.addAttribute("myBasketList", list);
		
		return "myPage/myBasket.myPage-tiles";
	}
	
	@RequestMapping(value = "addMyBasket",method = RequestMethod.POST)
	public String addMyBasket(@RequestParam long isbn
			,@RequestParam long userIdx
			,Model model) throws Exception {
		
		boolean check = myBasketService.insertMyBasket(isbn,userIdx);
		
		model.addAttribute("isSave", check);
		
		return "redirect:/book";
	}
}
