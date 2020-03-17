package com.example.ITBook.user.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.ITBook.common.domain.User;
import com.example.ITBook.user.service.UserUpdateService;

@Controller
@RequestMapping("/user/update")
public class UserUpdateController {

	@Autowired
	private UserUpdateService userUpdateService;
	
	public String userUpdate(@ModelAttribute User user, Model model) throws Exception{
		
		boolean isTrue = userUpdateService.checkIdAndPassword(user);
		
		if (isTrue) {
			
			
			
		} else {
			
		}
		
	}
}
