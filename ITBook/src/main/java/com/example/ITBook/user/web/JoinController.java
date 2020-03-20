package com.example.ITBook.user.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.ITBook.common.domain.User;
import com.example.ITBook.common.enums.SocialType;
import com.example.ITBook.common.exception.DoNotUpdateOrInsertException;
import com.example.ITBook.user.service.JoinService;

@Controller
@SessionAttributes("sessionId")
@RequestMapping("/join")
public class JoinController {

	@Autowired
	private JoinService joinService;
	
	@GetMapping(value ="/")
	public String join() {
		
		return "join/join.tiles2";
	}
	
	@PostMapping(value="/joinSuccess")
	public String joinSuccess(@ModelAttribute User user,String social, Model model) throws Exception{
		
		user.setSocialType(SocialType.valueOf(social));
		
		if (!joinService.insertUser(user).isPresent()) throw new DoNotUpdateOrInsertException();
		
		return "login/login.tiles2";
	}
}
