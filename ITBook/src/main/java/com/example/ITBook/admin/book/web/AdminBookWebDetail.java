package com.example.ITBook.admin.book.web;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.ITBook.admin.book.service.AdminBookDetailService;
import com.example.ITBook.domain.Book;

@Controller
@RequestMapping("/admin/book")
public class AdminBookWebDetail {
	private static final Logger logger = LoggerFactory.getLogger(AdminBookWebDetail.class);
	
	@Autowired
	private AdminBookDetailService adminBookDetailService;

	/*
	 * @param 		:  isbn(å ��ȣ), model
	 * @return		: ������ å ���� �� ������
	 * @addView()	: �� �������� �ø� �� ������ ����
	 */
	@GetMapping(value= "/detail")
	public String adminBookDetail(@RequestParam long isbn,Model model) throws Exception {
		
		Map<String,Object> rtnMap = adminBookDetailService.selectBookAndCategory(isbn);
		
		addView(rtnMap,model);
		
		return "book/bookDetail.adminTiles";
	}

	/*
	 * @param 	:  rtnMap(å�� ī�װ� ����), model
	 */
	private void addView(Map<String, Object> rtnMap, Model model) {

		model.addAttribute("scategory", rtnMap.get("s_category"));
		model.addAttribute("bcategory", rtnMap.get("b_category"));
		model.addAttribute("book", rtnMap.get("book"));
		model.addAttribute("category1", rtnMap.get("category1"));
		model.addAttribute("category2", rtnMap.get("category2"));
		
	}

	/*
	 * @param 		:  book(å ��ü),category1(�θ� ī�װ�),category2(�ڽ� ī�װ�)
	 * 					,isChangeB(å ���� ����),isChangeC(ī�װ� ���� ����), model
	 * @return		: ������ å ���� ���� ������
	 */
	@RequestMapping(value= "/update",method = RequestMethod.POST)
	public String adminBookUpdate(@ModelAttribute Book book,
			@RequestParam long category1
			,@RequestParam long category2
			,@RequestParam boolean isChangeB
			,@RequestParam boolean isChangeC) throws Exception {
		
		adminBookDetailService.updateBookInfo(book,category1,category2,isChangeB,isChangeC);
		
		return "redirect:adminBookMain";
	}
}
