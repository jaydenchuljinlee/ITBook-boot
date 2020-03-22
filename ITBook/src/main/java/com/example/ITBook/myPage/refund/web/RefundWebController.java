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
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.ITBook.common.annotation.Session;
import com.example.ITBook.common.domain.Payment;
import com.example.ITBook.common.domain.PaymentInformation;
import com.example.ITBook.common.domain.User;
import com.example.ITBook.common.utils.JsonUtil;
import com.example.ITBook.myPage.paymentList.service.PaymentService;
import com.example.ITBook.myPage.refund.service.RefundService;

/*
 * 환불 관련 컨트롤러
 * */

@Controller
@SessionAttributes("sessionId")
@RequestMapping("/refund")
public class RefundWebController {

	@Autowired
	private PaymentService paymentService;
	@Autowired
	private RefundService refundService;
	
	/*
	 * 결제 리스트 컨트롤러
	 * */
	@Session(name = "user")
	@GetMapping(value = "/")
	public String refundHome(User user,Model model) throws Exception {
		
		List<PaymentInformation> payInfoList = paymentService.selectList(user.getUserNo());
		
		model.addAttribute("payInfoList", payInfoList);
		
		return "myPage/refund.myPage-tiles";
	}
	
	/*
	 * 환불 요청 컨트롤러
	 * */
	@Session(name = "user")
	@GetMapping(value = "/request")
	@ResponseBody
	public String refundRequest(@RequestParam long pay_no,User user,Model model) throws Exception {
		
		boolean isSuccess = refundService.updatePaymentStateOnRefund(pay_no,user.getUserNo());
		
		HashMap<String, Object> rtnMap = new HashMap<>();
		
		if (isSuccess) rtnMap.put("RESULT", "SUCCESS");
		else rtnMap.put("RESULT", "FAILED");
		
		return JsonUtil.HashMapToJson(rtnMap);
	}
}
