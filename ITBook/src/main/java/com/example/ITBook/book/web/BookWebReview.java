package com.example.ITBook.book.web;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.ITBook.book.service.BookReviewService;
import com.example.ITBook.common.annotation.Session;
import com.example.ITBook.common.domain.Review;
import com.example.ITBook.common.domain.User;
import com.example.ITBook.common.exception.DoNotUpdateOrInsertException;

@Controller
@SessionAttributes("sessionId")
@RequestMapping("/book/review")
public class BookWebReview {
	private static final Logger logger = LoggerFactory.getLogger(BookWebReview.class);
	
	@Autowired
	private BookReviewService bookReviewService;	

	/*
	 * @info		: å ���� ���
	 * @param 		: isbn(å ��ȣ), session(����), model
	 * @return		: ���� Ŭ���ߴ� �� ������
	 * @Exception	: DoNotUpdateOrInsertException(������ �ݿ� ����)
	 */
	@Session(name = "user")
	@PostMapping(value = "/insert")
	public String bookReview(@ModelAttribute Review review
			,@RequestParam long isbn
			,User user
			,Model model) throws Exception{
		
		boolean isSuccess = bookReviewService.updateBookReview(review,isbn,user.getUserNo());
		
		if (!isSuccess) throw new DoNotUpdateOrInsertException();
		
		return "redirect:bookDetail?isbn="+isbn;
	}
	
	/*
	 * @info	: å ���� ������Ʈ
	 * @param 	: isbn(å ��ȣ), session(����), model
	 * @return	: ���� Ŭ���ߴ� �� ������
	 */
	@Session(name = "user")
	@PostMapping(value = "/update")
	public String bookReviewUpdate(@ModelAttribute Review review
			,@RequestParam long isbn
			,User user
			,Model model) throws Exception{
		
		boolean isSuccess = bookReviewService.deleteBookReview(review,isbn,user.getUserNo());
		
		if (!isSuccess) throw new DoNotUpdateOrInsertException();
		
		return "redirect:bookDetail?isbn="+isbn;
	}
	
	/*
	 * @info	: å ���� ����
	 * @param 	: isbn(å ��ȣ), session(����), model
	 * @return	: ���� Ŭ���ߴ� �� ������
	 */
	@Session(name = "user")
	@RequestMapping(value = "/delete",method = RequestMethod.POST)
	public String bookReviewDelete(@ModelAttribute Review review
			,@RequestParam long isbn
			,User user
			,Model model) throws Exception{
		
		boolean isSuccess = bookReviewService.insertBookReview(review,isbn,user.getUserNo());
		
		if (!isSuccess) throw new DoNotUpdateOrInsertException();
		
		return "redirect:bookDetail?isbn="+isbn;
	}
}
