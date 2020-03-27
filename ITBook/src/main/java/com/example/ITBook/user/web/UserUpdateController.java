package com.example.ITBook.user.web;

import java.util.Optional;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.ITBook.common.domain.User;
import com.example.ITBook.common.exception.DoNotUpdateOrInsertException;
import com.example.ITBook.user.service.UserUpdateService;

/*
* 유저 정보 변경 컨트롤러
* */
@Slf4j
@Controller
@SessionAttributes("user")
@RequestMapping("/mypage/modify")
public class UserUpdateController {

	@Autowired
	private UserUpdateService userUpdateService;

	/*
	* 정보 변경 메인 페이지
	* */
	@GetMapping()
	public String userUpdateMain() throws Exception {

		log.info("UserUpdateController.userUpdateMain :::");
		
		return "myPage/modifyCheckPassword.myPage-tiles";
	}

	/*
	* 정보 변경시 아이디와 비밀번호 재체크
	* */
	@PostMapping("/check")
	public String userUpdateCheck(@ModelAttribute User user, Model model) throws Exception{

		log.info("UserUpdateController.userUpdateCheck :::");

		Optional<User> relogin = userUpdateService.checkIdAndPassword(user);
		
		if (relogin.isPresent()) {
			
			model.addAttribute("user", relogin.get());
			
			return "myPage/modifyInformation.myPage-tiles";
			
		} else {
			
			return "redirect:/mypage/modify.myPage-tiles?check=false";
		}
	}

	/*
	* 유저 정보 변경
	* */
	@PostMapping("/update")
	public String userUpdate(@ModelAttribute User user, Model model) throws Exception{

		log.info("UserUpdateController.userUpdate :::");

		boolean isSuccess = userUpdateService.updateUser(user);
		
		if (!isSuccess) throw new DoNotUpdateOrInsertException();
		
		return "myPage/modifyInfo.myPage-tiles";
	}

	/*
	* 유저 정보 삭제(회원의 상태를 비활성화)
	* */
	@PostMapping("/delete")
	public String userDelete(@ModelAttribute User user, Model model) throws Exception{

		log.info("UserUpdateController.userDelete :::");

		Optional<User> relogin = userUpdateService.checkIdAndPassword(user);
		
		if (relogin.isPresent()) {
			
			boolean isSuccess = userUpdateService.deleteUser(user);
			
			if (!isSuccess) throw new DoNotUpdateOrInsertException();
			
			return "myPage/modifyInfo";
			
		} else {
			
			return "redirect:myPage/modifyCheckPassword";
		}
	}
}
