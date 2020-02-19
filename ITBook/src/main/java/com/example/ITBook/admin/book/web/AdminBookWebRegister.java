package com.example.ITBook.admin.book.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.ITBook.admin.book.domain.BookInformation;
import com.example.ITBook.admin.book.domain.NaverClientInformation;
import com.example.ITBook.admin.book.service.AdminBookService;
import com.example.ITBook.domain.Bcategory;
import com.example.ITBook.domain.Book;

@Controller
public class AdminBookWebRegister {
	private static final Logger logger = LoggerFactory.getLogger(AdminBookWebRegister.class);
	
	private AdminBookService adminBookService;
	
	public AdminBookWebRegister(AdminBookService adminBookService) {
		this.adminBookService = adminBookService;
	}

	@ModelAttribute("categoryList_1")
	public List<Bcategory> categoryList_1(ModelMap model) throws Exception {
		return adminBookService.selectParentCategoryList();
	}
	
	@RequestMapping(value= "adminBookRegister")
	public String adminBookRegister() throws Exception {
		
		return "book/bookRegister.adminTiles";
	}
	
	/**
	 * 책 검색 크롤링
	 * @param book : 책 객체, category1 : 대분류, category2 : 소분류, hash : 해시태그
	 * @return : 해당페이지 redirect + 등록 여부
	 * @throws Exception
	 */
	@RequestMapping(value = "BookRegisterSuccess",method = RequestMethod.POST)
	public String BookRegisterSuccess(@ModelAttribute Book book,
			@RequestParam long category1
			,@RequestParam long category2
			,@RequestParam(required=false) List<Long> hash
			,Model model) throws Exception {

		boolean bookCheck = adminBookService.insertBook(book,category1,category2,hash);
		
		return "redirect:adminBookMain?bookCheck="+bookCheck;
	}
	
	/**
	 * 책 검색 크롤링
	 * @param isbn : 검색한 isbn
	 * @return : 크롤링한 도큐먼트
	 * @throws Exception
	 */
	@RequestMapping(value= "adminBookSearch", produces = "application/xml; charset=utf8")
	@ResponseBody
	public String adminBookSearch(@RequestParam String isbn) throws Exception {

		NaverClientInformation naverDocument = new NaverClientInformation(isbn);
		
        return naverDocument.getDocument();
	}
	
	/**
	 * 책 상세 정보 가져오기
	 * @param url : 네이버 책 상세 페이지 url
	 * @return : 상세 정보 JSON
	 * @throws Exception
	 */
	@RequestMapping(value= "adminBookSearchDetail", produces = "application/json; charset=utf8")
	@ResponseBody
	public String adminBookSearchDetail(@RequestParam String url) throws Exception {
		
		BookInformation bookInfo = new BookInformation(url);
		
		return bookInfo.getBookJsonObject().toString();
	}
	
	
}
