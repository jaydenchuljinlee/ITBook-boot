package com.example.ITBook.book.web;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.ITBook.book.service.BookDetailService;
import com.example.ITBook.common.domain.Book;
import com.example.ITBook.common.domain.Review;
import com.example.ITBook.common.domain.User;

@Controller
@RequestMapping("/book/detail")
public class BookWebDetail {
	private static final Logger logger = LoggerFactory.getLogger(BookWebDetail.class);

	@Autowired
	private BookDetailService bookDetailService;
	
	/*
	 * @param 	: isbn(책 번호), session(세션), model
	 * @return	: 디테일 페이지
	 */
	@RequestMapping(value = "/")
	private String bookDetail(@RequestParam Long isbn
			,HttpSession session
			,Model model) {
		
		try {
			
			Optional<Book> book = bookDetailService.selectOneBook(isbn);
			
			Map<String, Object> rvMap = bookDetailService.selectReviewList(isbn);
			
			model.addAttribute("book", book.get());
			model.addAttribute("userSession", ((User)session.getAttribute("user")).getIdx());
			model.addAttribute("bookGrade", rvMap.get("grade"));
			model.addAttribute("bookLength", rvMap.get("length"));
			model.addAttribute("reviewList", rvMap.get("rvList"));
			
		} catch(Exception e) {
			
			logger.error(e.getMessage());
			
			throw new RuntimeException();
		}
		
		return "book_detail/bookDetail.book-main";
	}
}
