package com.example.ITBook.myPage.paymentList.web;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.ITBook.domain.PayInfo;


@Controller
public class PayemntListWebController {

	@RequestMapping(value = "payment")
	public String payment(@ModelAttribute PayInfo payInfo
			,Model model) throws Exception {
		
		model.addAttribute("payInfo", payInfo);
		
		return "myPage/payment.myPage-tiles";
	}
}
