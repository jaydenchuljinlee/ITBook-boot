package com.example.ITBook.user.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.ITBook.common.domain.User;
import com.example.ITBook.common.exception.DoNotUpdateOrInsertException;
import com.example.ITBook.user.service.UserUpdateService;

@Controller
@RequestMapping("/mypage/modify")
public class UserUpdateController {

	@Autowired
	private UserUpdateService userUpdateService;
	
	@PostMapping("/")
	public String userUpdate(@ModelAttribute User user, Model model) throws Exception{
		
		boolean isTrue = userUpdateService.checkIdAndPassword(user);
		
		if (isTrue) {
			
			if (!userUpdateService.updateUser(user).isPresent()) throw new DoNotUpdateOrInsertException();
			
			return "myPage/modifyInfo";
			
		} else {
			
			return "redirect:myPage/modifyCheckPassword";
		}
	}
	
	@PostMapping("/delete")
	public String userDelete(@ModelAttribute User user, Model model) throws Exception{
		
		boolean isTrue = userUpdateService.checkIdAndPassword(user);
		
		if (isTrue) {
			
			if (!userUpdateService.deleteUser(user).isPresent()) throw new DoNotUpdateOrInsertException();
			
			return "myPage/modifyInfo";
			
		} else {
			
			return "redirect:myPage/modifyCheckPassword";
		}
	}
}
