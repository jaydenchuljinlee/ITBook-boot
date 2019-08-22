package com.example.ITBook.admin.book.web;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.ITBook.admin.book.service.AdminBookDetailService;
import com.example.ITBook.domain.Bcategory;
import com.example.ITBook.domain.Book;
import com.example.ITBook.domain.Scategory;

@Controller
public class AdminBookWebDetail {
	private static final Logger logger = LoggerFactory.getLogger(AdminBookWebDetail.class);
	
	private AdminBookDetailService adminBookDetailService;
	
	public AdminBookWebDetail(AdminBookDetailService adminBookDetailService) {
		this.adminBookDetailService = adminBookDetailService;
	}

	@RequestMapping(value= "adminBookDetail")
	public String adminBookDetail(@RequestParam long isbn,Model model) throws Exception {
		
		Map<String,Object> rtnMap = adminBookDetailService.selectBookAndCategory(isbn);
		
		addView(rtnMap,model);
		
		return "book/bookDetail.adminTiles";
	}

	private void addView(Map<String, Object> rtnMap, Model model) {

		model.addAttribute("scategory", rtnMap.get("s_category"));
		model.addAttribute("bcategory", rtnMap.get("b_category"));
		model.addAttribute("book", rtnMap.get("book"));
		model.addAttribute("category1", rtnMap.get("category1"));
		model.addAttribute("category2", rtnMap.get("category2"));
		
	}

	@RequestMapping(value= "adminBookUpdate",method = RequestMethod.POST)
	public String adminBookUpdate(@ModelAttribute Book book,
			@RequestParam long category1
			,@RequestParam long category2
			,@RequestParam List<Long> hash) throws Exception {
		
		adminBookDetailService.updateBookInfo(book,category1,category2,hash);
		
		return "redirect:adminBookMain";
	}
}
