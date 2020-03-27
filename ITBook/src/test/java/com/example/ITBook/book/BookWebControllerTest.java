package com.example.ITBook.book;

import java.time.LocalDateTime;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.example.ITBook.common.domain.Bcategory;
import com.example.ITBook.common.domain.Book;
import com.example.ITBook.common.domain.Scategory;

import lombok.extern.slf4j.Slf4j;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc //need this in Spring Boot test
public class BookWebControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Before
	public void setUp() {
		log.info("BookWebControllerTest.setUp :::");
	}
	
	@Test
	@WithMockUser(username = "user",roles = "USER")
	public void book_mvc_mock_테스트() throws Exception {
		
		assertThat(mockMvc).isNotNull();
		
		mockMvc.perform(get("/book"))
			.andDo(print())
			.andExpect(status().isOk());
	}
	
	@Test
	@WithMockUser(username = "user",roles = "USER")
	public void recommend_book_mvc_mock_테스트() throws Exception {
		
		assertThat(mockMvc).isNotNull();
		
		mockMvc.perform(get("/recommendBook"))
			.andDo(print())
			.andExpect(status().isOk());
	}
}
