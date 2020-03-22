package com.example.ITBook.user.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.ITBook.common.annotation.Session;
import com.example.ITBook.common.domain.User;
import com.example.ITBook.common.enums.SocialType;
import com.example.ITBook.common.exception.DoNotUpdateOrInsertException;
import com.example.ITBook.user.service.JoinService;

@Controller
@RequestMapping("/join")
public class JoinController {
	private static final Logger logger = LoggerFactory.getLogger(JoinController.class);
	
	@Autowired
	private JoinService joinService;
	
	@GetMapping()
	public String join() {
		
		return "join/join.join";
	}
	
	@PostMapping(value="/identityCheck")
	@ResponseBody
	public String identityCheck(@RequestParam(required = false) String identity) throws Exception {
		
		if (!joinService.findByEmail(identity)) return "0";
		else return "1";
	}
	
	@PostMapping(value="/joinSuccess")
	public String joinSuccess(@ModelAttribute User user, Model model) throws Exception{
		
		boolean isSuccess = joinService.insertUser(user);
		
		if (!isSuccess) throw new DoNotUpdateOrInsertException();
		
		return "login/login.tiles2";
	}
}
