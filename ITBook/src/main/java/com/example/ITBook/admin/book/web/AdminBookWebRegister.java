package com.example.ITBook.admin.book.web;

import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.ITBook.admin.book.domain.BookInformation;
import com.example.ITBook.admin.book.domain.NaverClientInformation;
import com.example.ITBook.admin.book.service.AdminBookService;
import com.example.ITBook.domain.Bcategory;
import com.example.ITBook.domain.Scategory;
import com.example.ITBook.utils.JsonUtil;

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
	
	@RequestMapping(value = "categoryList_2")
	@ResponseBody
	public Map<String, Object> categoryList2(@RequestBody String reqParam) throws Exception {
		
			long param;
			String parameter = "";
			
			parameter = URLDecoder.decode(reqParam, "utf-8");
			
			Map resMap = JsonUtil.JsonToMap(parameter);
			
			param = Long.parseLong((String) resMap.get("param"));
			
			Bcategory parent = new Bcategory(param);
			
			List<Scategory> sCategory = adminBookService.selectChildCategoryList(parent);
			
			Map<String, Object> resultMap = new HashMap<String, Object>();
			
			resultMap.put("result", "SUCCESS");
			resultMap.put("list", sCategory);
			
			return resultMap;
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
