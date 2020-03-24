package com.example.ITBook.user.web;

import com.example.ITBook.common.annotation.SocialUser;
import com.example.ITBook.common.domain.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@SessionAttributes("user")
@Controller
public class LoginController {
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@GetMapping("/login")
    public String login() {
        return "login/login.tiles2";
    }

    @PostMapping("/loginCheck")
    public String loginCheck(@RequestParam String identity,@RequestParam String password) {
        return "login/login.tiles2";
    }

	@RequestMapping("/loginSuccess")
    public String loginSuccess(@SocialUser User user) {
        logger.info("loginSuccess");
        return "redirect:/main";
    }
}
