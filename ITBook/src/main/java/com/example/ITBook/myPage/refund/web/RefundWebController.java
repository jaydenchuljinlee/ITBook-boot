package com.example.ITBook.myPage.refund.web;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.ITBook.common.domain.Payment;
import com.example.ITBook.common.domain.PaymentInformation;
import com.example.ITBook.common.domain.User;
import com.example.ITBook.common.utils.JsonUtil;
import com.example.ITBook.myPage.paymentList.service.PaymentService;
import com.example.ITBook.myPage.refund.service.RefundService;

@Controller
@RequestMapping("/refund")
public class RefundWebController {

	@Autowired
	private PaymentService paymentService;
	@Autowired
	private RefundService refundService;
	
	/*
	 * 결제 리스트 컨트롤러
	 * */
	@GetMapping(value = "/")
	public String refundHome(HttpSession session,Model model) throws Exception {
		
		User user = (User) session.getAttribute("user");
		
		List<PaymentInformation> payInfoList = paymentService.selectList(user.getUser_no());
		
		model.addAttribute("payInfoList", payInfoList);
		
		return "myPage/refund.myPage-tiles";
	}
	
	/*
	 * 환불 요청 컨트롤러
	 * */
	@GetMapping(value = "/request")
	@ResponseBody
	public String refundRequest(@RequestParam long pay_no,HttpSession session,Model model) throws Exception {
		
		User user = (User) session.getAttribute("user");
		
		Optional<Payment> payStateCheck = refundService.updatePaymentStateOnRefund(pay_no,user.getUser_no());
		
		HashMap<String, Object> rtnMap = new HashMap<>();
		
		if (payStateCheck.isPresent()) rtnMap.put("RESULT", "SUCCESS");
		else rtnMap.put("RESULT", "FAILED");
		
		return JsonUtil.HashMapToJson(rtnMap);
	}
}
