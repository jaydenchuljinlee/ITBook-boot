package com.example.ITBook.admin.book;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.example.ITBook.utils.JsonUtil;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc //need this in Spring Boot test
public class AdminBookCategoryTest {
	private static final Logger logger = LoggerFactory.getLogger(AdminBookCategoryTest.class);
	
	@Autowired
	private MockMvc mockMvc;
	
	private HashMap<String,Object> map;
	
	@Before
	public void setUp() {
		
		map = new HashMap<>();
		
		map.put("param", "1");
		
		logger.info("set up....");
		
		
	}
	
	@Test
	@WithMockUser(username = "user",roles = "ADMIN")
	public void admin_book_카테고리_테스트() throws Exception {
		
		mockMvc.perform(post("/admin/book/categoryList_2")
						.content(JsonUtil.HashMapToJson(map)))
			.andDo(print())
			.andExpect(status().isOk());
	}
	
}
