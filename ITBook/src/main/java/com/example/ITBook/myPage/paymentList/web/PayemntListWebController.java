package com.example.ITBook.myPage.paymentList.web;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.ITBook.common.domain.Book;
import com.example.ITBook.common.domain.PayInfo;
import com.example.ITBook.common.domain.Payment;
import com.example.ITBook.common.domain.PaymentInformation;
import com.example.ITBook.common.domain.User;
import com.example.ITBook.myPage.paymentList.service.PaymentService;


@Controller
public class PayemntListWebController {
	
	private PaymentService paymentService;
	
	public PayemntListWebController(PaymentService paymentService) {
		this.paymentService = paymentService;
	}

	@RequestMapping(value = "payment")
	public String payment(@ModelAttribute PayInfo payInfo
			,HttpSession session
			,Model model) throws Exception {
		
		List<Book> list = new ArrayList<Book>();
		
		int length = payInfo.getIsbn().size();
		
		for(int i = 0; i < length; i++) {
			
			Book book = new Book();
			
			book.setIsbn(payInfo.getIsbn().get(i));
			book.setTheme(payInfo.getTheme().get(i));
			book.setImage(payInfo.getThumb().get(i));
			book.setQuantity(payInfo.getQuantity().get(i));
			book.setPrice(payInfo.getPrice().get(i));
			
			list.add(book);
		}
		
		model.addAttribute("session", ((User)session.getAttribute("user")));
		model.addAttribute("bookList", list);
		model.addAttribute("genreCnt", payInfo.getGenreCnt());
		model.addAttribute("totalFee", payInfo.getTotalFee());
		model.addAttribute("totalCnt", payInfo.getTotalCnt());
		model.addAttribute("totalMil", payInfo.getTotalMil());
		model.addAttribute("delivery", payInfo.getDelivery());
		
		return "myPage/payment.myPage-tiles";
	}
	
	@RequestMapping(value="completePay", method = RequestMethod.POST)
	public String completePay(@ModelAttribute Payment payment
			,@ModelAttribute PayInfo payInfo
			,HttpSession session
			,Model model) throws Exception {
	
		List<PaymentInformation> payInfoList = paymentService.insertpayInfo(payment,payInfo,session);
		
		model.addAttribute("payInfoList", payInfoList);
		
		return "myPage/completePay.myPage-tiles";
	}
}
