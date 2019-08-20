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
	
	@RequestMapping(value = "BookRegisterSuccess",method = RequestMethod.POST)
	public String BookRegisterSuccess(@ModelAttribute Book book,
			@RequestParam long category1
			,@RequestParam long category2
			,Model model) throws Exception {
		
		
		boolean bookCheck = adminBookService.insertBook(book,category1,category2);
		
		model.addAttribute("bookCheck", bookCheck);
		
		return "redirect:adminBookMain";
	}
	
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
