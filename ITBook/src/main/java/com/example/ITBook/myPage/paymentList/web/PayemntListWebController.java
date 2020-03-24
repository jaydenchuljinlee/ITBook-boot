package com.example.ITBook.myPage.paymentList.web;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.ITBook.common.annotation.Session;
import com.example.ITBook.common.domain.Book;
import com.example.ITBook.common.domain.PayInfo;
import com.example.ITBook.common.domain.Payment;
import com.example.ITBook.common.domain.PaymentInformation;
import com.example.ITBook.common.domain.User;
import com.example.ITBook.myPage.paymentList.service.PaymentService;

/*
 * 결제 관련 컨트롤러
 * */

@Controller
@SessionAttributes("user")
@RequestMapping("/payment")
public class PayemntListWebController {
	
	@Autowired
	private PaymentService paymentService;

	/*
	 * 장바구니 -> 결제 페이지
	 * */
	@PostMapping(value = "/")
	public String payment(@ModelAttribute PayInfo payInfo
			,Model model) throws Exception {
		
		List<Book> list = new ArrayList<Book>();
		
		setBookList(list,payInfo);//책 정보 세팅
		
		model.addAttribute("bookList", list);
		model.addAttribute("genreCnt", payInfo.getGenreCnt());
		model.addAttribute("totalFee", payInfo.getTotalFee());
		model.addAttribute("totalCnt", payInfo.getTotalCnt());
		model.addAttribute("totalMil", payInfo.getTotalMil());
		model.addAttribute("delivery", payInfo.getDelivery());
		
		return "myPage/payment.myPage-tiles";
	}
	
	/*
	 * 결제 완료
	 * */
	@Session(name = "user")
	@PostMapping(value="/completePay")
	public String completePay(@ModelAttribute Payment payment
			,@ModelAttribute PayInfo payInfo
			,User user
			,Model model) throws Exception {
	
		List<PaymentInformation> payInfoList = paymentService.insertpayInfo(payment,payInfo,user);
		
		model.addAttribute("payInfoList", payInfoList);
		
		return "myPage/completePay.myPage-tiles";
	}
	
	/*
	 * 결제 정보에 대한 책 정보 리스트 세팅
	 * */
	private void setBookList(List<Book> list, PayInfo payInfo) {

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
		
	}
}
