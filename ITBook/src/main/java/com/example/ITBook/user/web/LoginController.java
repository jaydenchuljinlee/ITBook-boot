package com.example.ITBook.user.web;

import com.example.ITBook.common.annotation.SocialUser;
import com.example.ITBook.common.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

	@GetMapping("/login")
    public String login() {
        return "login/login.tiles2";
    }

	@RequestMapping("/loginSuccess")
    public String loginSuccess(@SocialUser User user) {
        return "redirect:/main";
    }
}
