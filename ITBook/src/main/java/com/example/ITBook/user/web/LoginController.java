package com.example.ITBook.user.web;

import com.example.ITBook.common.annotation.SocialUser;
import com.example.ITBook.common.domain.User;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/*
* 로그인 관련 컨트롤러
* */

@Slf4j
@SessionAttributes("user")
@Controller
public class LoginController {

	/*
	* 로그인 메인 페이지
	* */
	@GetMapping("/login")
    public String login() {

	    log.info("LoginController.login :::");

        return "login/login.tiles2";
    }

    /*
    * @todo : 시큐리티에서 oauth2와 일반 사용자 로그인 통합
    * 로그인 체크
    * */
    @PostMapping("/loginCheck")
    public String loginCheck(@RequestParam String identity,@RequestParam String password) {

        log.info("LoginController.loginCheck :::");

        return "login/login.tiles2";
    }

    /*
    * 로그인 성공 페이지
    * */
	@RequestMapping("/loginSuccess")
    public String loginSuccess(@SocialUser User user) {
        log.info("LoginController.loginSuccess :::");
        return "redirect:/main";
    }
}
