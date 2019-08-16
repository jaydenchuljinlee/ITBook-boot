package com.example.ITBook.controller;

import com.example.ITBook.annotation.SocialUser;
import com.example.ITBook.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

	@RequestMapping("/login")
    public String login() {
        return "login/login.tiles2";
    }

	@RequestMapping("/loginSuccess")
    public String loginSuccess(@SocialUser User user) {
        return "redirect:/board";
    }
}
