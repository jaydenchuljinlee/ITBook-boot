package com.example.ITBook.admin.book;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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

import com.example.ITBook.book.BookWebControllerTest;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc //need this in Spring Boot test
public class AdminBookWebControllerTest {

private static final Logger logger = LoggerFactory.getLogger(AdminBookWebControllerTest.class);
	
	@Autowired
	private MockMvc mockMvc;
	
	@Before
	public void setUp() {
		logger.info("set up....");
	}
	
	@Test
	@WithMockUser(username = "user",roles = "USER")
	public void admin_권한_테스트() throws Exception {
		
		mockMvc.perform(get("/admin/book/"))
			.andDo(print())
			.andExpect(status().is(403));
	}
	
	@Test
	@WithMockUser(username = "user",roles = "ADMIN")
	public void admin_book_메인_테스트() throws Exception {
		
		mockMvc.perform(get("/admin/book/"))
			.andDo(print())
			.andExpect(status().isOk());
	}
	
	
}
