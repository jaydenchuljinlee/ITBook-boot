package com.example.ITBook.user.web;

import com.example.ITBook.common.annotation.SocialUser;
import com.example.ITBook.common.domain.User;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/*
* �α��� ���� ��Ʈ�ѷ�
* */

@Slf4j
@SessionAttributes("user")
@Controller
public class LoginController {

	/*
	* �α��� ���� ������
	* */
	@GetMapping("/login")
    public String login() {

	    log.info("LoginController.login :::");

        return "login/login.tiles2";
    }

    /*
    * @todo : ��ť��Ƽ���� oauth2�� �Ϲ� ����� �α��� ����
    * �α��� üũ
    * */
    @PostMapping("/loginCheck")
    public String loginCheck(@RequestParam String identity,@RequestParam String password) {

        log.info("LoginController.loginCheck :::");

        return "login/login.tiles2";
    }

    /*
    * �α��� ���� ������
    * */
	@RequestMapping("/loginSuccess")
    public String loginSuccess(@SocialUser User user) {
        log.info("LoginController.loginSuccess :::");
        return "redirect:/main";
    }
}
