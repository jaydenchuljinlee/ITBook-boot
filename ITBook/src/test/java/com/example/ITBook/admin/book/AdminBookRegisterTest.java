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

import com.example.ITBook.admin.book.domain.NaverClientInformation;
import com.example.ITBook.domain.Bcategory;
import com.example.ITBook.domain.Book;
import com.example.ITBook.domain.Hashtag;
import com.example.ITBook.domain.Scategory;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class AdminBookRegisterTest {
	private static final Logger logger = LoggerFactory.getLogger(AdminBookRegisterTest.class);
	
	@Autowired
	private MockMvc mockMvc;
	
	private NaverClientInformation naverDocument;
	
	private Book book;
	private Bcategory bcategory;
	private Scategory scategory;
	private Hashtag hashtage;
	
	@Before
	public void setUp() throws Exception{
		
		naverDocument = new NaverClientInformation("20120099");
		
		bcategory = new Bcategory(1);
		scategory = new Scategory(1,bcategory);
		
		
		logger.info("set up ...");
	}
	
	@Test
	@WithMockUser(username = "user", roles = "ADMIN")
	public void 관리자_책_등록_테스트() throws Exception{
		
		mockMvc.perform(get("/admin/book/detail")
							.param("isbn", "21012022"))
			.andDo(print())
			.andExpect(status().isOk());
	}
}
