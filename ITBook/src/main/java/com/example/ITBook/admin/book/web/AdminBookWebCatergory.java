package com.example.ITBook.admin.book.web;

import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.ITBook.admin.book.service.AdminBookService;
import com.example.ITBook.domain.Bcategory;
import com.example.ITBook.domain.Scategory;
import com.example.ITBook.utils.JsonUtil;

@Controller
public class AdminBookWebCatergory {
	
	private AdminBookService adminBookService;
	
	public AdminBookWebCatergory(AdminBookService adminBookService) {
		this.adminBookService = adminBookService;
	}

	@RequestMapping(value = "categoryList_2")
	@ResponseBody
	public Map<String, Object> categoryList2(@RequestBody String reqParam) throws Exception {
		
			long param;
			String parameter = "";
			
			parameter = URLDecoder.decode(reqParam, "utf-8");
			
			Map<String, Object> resMap = JsonUtil.JsonToMap(parameter);
			
			param = Long.parseLong((String) resMap.get("param"));
			
			Bcategory parent = new Bcategory(param);
			
			List<Scategory> sCategory = adminBookService.selectChildCategoryList(parent);
			
			Map<String, Object> resultMap = new HashMap<String, Object>();
			
			resultMap.put("result", "SUCCESS");
			resultMap.put("list", sCategory);
			
			return resultMap;
	}
}
