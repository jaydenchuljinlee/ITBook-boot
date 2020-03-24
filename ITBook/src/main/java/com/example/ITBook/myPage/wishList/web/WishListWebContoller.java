package com.example.ITBook.myPage.wishList.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@SessionAttributes("user")
@Controller
public class WishListWebContoller {

	@RequestMapping(value = "wishList")
	public String wishList(Model model) throws Exception {
		
		return "myPage/wishList.mypage-tiles";
	}
}
