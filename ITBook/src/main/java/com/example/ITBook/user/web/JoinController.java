package com.example.ITBook.user.web;

import lombok.extern.slf4j.Slf4j;
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

/*
* 회원가입 컨트롤러
* */
@Slf4j
@Controller
@RequestMapping("/join")
public class JoinController {
	
	@Autowired
	private JoinService joinService;

	/*
	* 회원가입 메인 페이지
	* */
	@GetMapping()
	public String join() {

		log.info("JoinController.join");
		
		return "join/join.join";
	}

	/*
	* 아이디 중복 체크
	* */
	@PostMapping(value="/identityCheck")
	@ResponseBody
	public String identityCheck(@RequestParam(required = false) String identity) throws Exception {

		log.info("JoinController.identityCheck");

		if (!joinService.findByEmail(identity)) return "0";
		else return "1";
	}


	/*
	* 회원가입 성공
	* */
	@PostMapping(value="/joinSuccess")
	public String joinSuccess(@ModelAttribute User user, Model model) throws Exception{

		log.info("JoinController.joinSuccess");

		boolean isSuccess = joinService.insertUser(user);
		
		if (!isSuccess) throw new DoNotUpdateOrInsertException();
		
		return "login/login.tiles2";
	}
}
