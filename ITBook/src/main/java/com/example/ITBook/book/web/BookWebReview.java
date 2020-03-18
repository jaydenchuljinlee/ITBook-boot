package com.example.ITBook.book.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.ITBook.book.service.BookReviewService;
import com.example.ITBook.common.domain.Review;
import com.example.ITBook.common.domain.User;

@Controller
@RequestMapping("/book/review")
public class BookWebReview {
	private static final Logger logger = LoggerFactory.getLogger(BookWebReview.class);
	
	@Autowired
	private BookReviewService bookReviewService;	

	/*
	 * @info	: 책 리뷰 등록
	 * @param 	: isbn(책 번호), session(세션), model
	 * @return	: 기존 클릭했던 상세 페이지
	 */
	@RequestMapping(value = "/insert",method = RequestMethod.POST)
	public String bookReview(@ModelAttribute Review review
			,@RequestParam long isbn
			,HttpSession session
			,Model model) {
		
		try {
			
			bookReviewService.updateBookReview(review,isbn,((User) session.getAttribute("user")).getUser_no());

		} catch (Exception e) {
			
			logger.error(e.getMessage());
			throw new RuntimeException();
		}
		
		return "redirect:bookDetail?isbn="+isbn;
	}
	
	/*
	 * @info	: 책 리뷰 업데이트
	 * @param 	: isbn(책 번호), session(세션), model
	 * @return	: 기존 클릭했던 상세 페이지
	 */
	@RequestMapping(value = "/update",method = RequestMethod.POST)
	public String bookReviewUpdate(@ModelAttribute Review review
			,@RequestParam long isbn
			,HttpSession session
			,Model model) {
		
		try {
			
			bookReviewService.deleteBookReview(review,isbn,((User) session.getAttribute("user")).getUser_no());

		} catch (Exception e) {
			
			logger.error(e.getMessage());
			throw new RuntimeException();
		}
		
		return "redirect:bookDetail?isbn="+isbn;
	}
	
	/*
	 * @info	: 책 리뷰 삭제
	 * @param 	: isbn(책 번호), session(세션), model
	 * @return	: 기존 클릭했던 상세 페이지
	 */
	@RequestMapping(value = "/delete",method = RequestMethod.POST)
	public String bookReviewDelete(@ModelAttribute Review review
			,@RequestParam long isbn
			,HttpSession session
			,Model model) {
		
		try {
			
			bookReviewService.insertBookReview(review,isbn,((User) session.getAttribute("user")).getUser_no());

		} catch (Exception e) {
			
			logger.error(e.getMessage());
			throw new RuntimeException();
		}
		
		return "redirect:bookDetail?isbn="+isbn;
	}
}
