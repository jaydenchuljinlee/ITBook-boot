package com.example.ITBook.myPage.myBasket.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.ITBook.common.annotation.Session;
import com.example.ITBook.common.domain.MyBasket;
import com.example.ITBook.common.domain.User;
import com.example.ITBook.common.exception.DoNotUpdateOrInsertException;
import com.example.ITBook.common.utils.JsonUtil;
import com.example.ITBook.myPage.myBasket.service.MyBasketService;

@SessionAttributes("user")
@RequestMapping("/myBasket")
@Controller
public class MyBasketWebController {
	private static final Logger logger = LoggerFactory.getLogger(MyBasketWebController.class);
	
	@Autowired
	private MyBasketService myBasketService;

	/*
	 * 장바구니 메인
	 * */
	@Session(name = "user")
	@GetMapping()
	public String mybascket(User user
			,Model model) throws Exception {
		
		List<MyBasket> list = myBasketService.selectByUser(user.getUserNo());
		
		model.addAttribute("myBasketList", list);
		
		return "myPage/myBasket.myPage-tiles";
	}
	
	/*
	 * 장바구니 추가
	 * */
	@PostMapping(value = "/addMyBasket")
	public String addMyBasket(@RequestParam long isbn
			,@RequestParam long userIdx
			,Model model) throws Exception {
		
		boolean isSuccess = myBasketService.insertMyBasket(isbn,userIdx);

		if (!isSuccess) new DoNotUpdateOrInsertException();
		
		return "redirect:/book";
	}
	
	/*
	 * 장바구니 삭제
	 * */
	@Session(name = "user")
	@PostMapping(value = "/deleteMyBasket")
	@ResponseBody
	public String deleteMyBasket(@RequestParam(required=false) long isbn
			,User user) throws Exception {
		
		boolean isSuccess = myBasketService.deleteMyBasket(isbn,user);

		if (!isSuccess) new DoNotUpdateOrInsertException();
		
		HashMap<String, Object> map = new HashMap<>();
		
		map.put("RESULT", "SUCCESS");
		
		return JsonUtil.HashMapToJson(map);
	}
}
