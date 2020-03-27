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
* ���� ���� ���� ��Ʈ�ѷ�
* */
@Slf4j
@Controller
@SessionAttributes("user")
@RequestMapping("/mypage/modify")
public class UserUpdateController {

	@Autowired
	private UserUpdateService userUpdateService;

	/*
	* ���� ���� ���� ������
	* */
	@GetMapping()
	public String userUpdateMain() throws Exception {

		log.info("UserUpdateController.userUpdateMain :::");
		
		return "myPage/modifyCheckPassword.myPage-tiles";
	}

	/*
	* ���� ����� ���̵�� ��й�ȣ ��üũ
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
	* ���� ���� ����
	* */
	@PostMapping("/update")
	public String userUpdate(@ModelAttribute User user, Model model) throws Exception{

		log.info("UserUpdateController.userUpdate :::");

		boolean isSuccess = userUpdateService.updateUser(user);
		
		if (!isSuccess) throw new DoNotUpdateOrInsertException();
		
		return "myPage/modifyInfo.myPage-tiles";
	}

	/*
	* ���� ���� ����(ȸ���� ���¸� ��Ȱ��ȭ)
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
