package com.example.ITBook.myPage.myBasket.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.ITBook.common.domain.MyBasket;
import com.example.ITBook.common.domain.User;
import com.example.ITBook.common.utils.JsonUtil;
import com.example.ITBook.myPage.myBasket.service.MyBasketService;

@Controller
public class MyBasketWebController {
	private static final Logger logger = LoggerFactory.getLogger(MyBasketWebController.class);
	
	@Autowired
	private MyBasketService myBasketService;

	/*
	 * 장바구니 메인
	 * */
	@RequestMapping(value = "myBasket")
	public String mybascket(HttpSession session
			,Model model) throws Exception {
		
		List<MyBasket> list = myBasketService.selectByUser(((User)session.getAttribute("user")).getUser_no());
		
		model.addAttribute("myBasketList", list);
		
		return "myPage/myBasket.myPage-tiles";
	}
	
	/*
	 * 장바구니 추가
	 * */
	@RequestMapping(value = "addMyBasket",method = RequestMethod.POST)
	public String addMyBasket(@RequestParam long isbn
			,@RequestParam long userIdx
			,Model model) throws Exception {
		
		boolean check = myBasketService.insertMyBasket(isbn,userIdx);
		
		model.addAttribute("isSave", check);
		
		return "redirect:/book";
	}
	
	/*
	 * 장바구니 삭제
	 * */
	@RequestMapping(value = "deleteMyBasket",method = RequestMethod.POST)
	@ResponseBody
	public String deleteMyBasket(@RequestParam(required=false) long isbn
			,HttpSession session) throws Exception {
		
		HashMap<String ,Object> map = myBasketService.deleteMyBasket(isbn,((User)session.getAttribute("user")));
		
		return JsonUtil.HashMapToJson(map);
	}
}
