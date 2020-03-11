package com.example.ITBook.admin.book;

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

import com.example.ITBook.common.domain.Bcategory;
import com.example.ITBook.common.domain.Book;
import com.example.ITBook.common.domain.Scategory;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class AdminBookDetailTest {
	private static final Logger logger = LoggerFactory.getLogger(AdminBookDetailTest.class);
	
	@Autowired
	private MockMvc mockMvc;
	
	private Book book;
	private Bcategory bcategory;
	private Scategory scategory;
	
	@Before
	public void setUp() {
		
		
		
		logger.info("set up ...");
	}
	
	@Test
	@WithMockUser(username = "user", roles = "ADMIN")
	public void 관리자_북_디테일_테스트() throws Exception{
		
		mockMvc.perform(get("/admin/book/detail")
							.param("isbn", "21012022"))
			.andDo(print())
			.andExpect(status().isOk());
	}
}
