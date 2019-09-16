package com.example.ITBook.book;

import java.time.LocalDateTime;
import java.util.Collections;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.example.ITBook.book.service.BookService;
import com.example.ITBook.book.web.BookWebController;
import com.example.ITBook.domain.Bcategory;
import com.example.ITBook.domain.Book;
import com.example.ITBook.domain.Scategory;

import static org.hamcrest.Matchers.contains;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(SpringRunner.class)
@SpringBootTest
//@WebMvcTest(BookWebController.class)
@AutoConfigureMockMvc //need this in Spring Boot test
public class BookWebControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	
	@MockBean
	BookService bookService;
	
	@Test
	@WithMockUser
	public void book_mvc_mock_테스트() throws Exception {
		
		//부모 카테고리 생성
		Bcategory bcategory = new Bcategory(1);
		
		//자식 카테고리 생성
		Scategory scategory = Scategory.builder()
								.code((long)1)
								.bcategory(bcategory).build();
		
		//book 객체 생성
		Book book = Book.builder()
				.isbn((long) 123455678)
				.price(123)
				.author("이철진")
				.authorinfo("개발자")
				.contents("컨텐츠")
				.image("이미지 경로")
				.intro("인트로")
				.original("오리지널")
				.publish("출판사")
				.quantity(1)
				.translator("역자")
				.s_category(scategory)
				.theme("Hello World")
				.publishdate(LocalDateTime.now())
				.build();
		
		// bookService.selectBookListAll()를 호출하면 Collections.singletonList(book)를 리턴하도록 지정
		given(bookService.selectBookListAll()).willReturn(Collections.singletonList(book));
		
		mockMvc.perform(get("/book")) // /book로 get 요청
				.andExpect(status().isOk()) //상태 200 (ok)
				.andExpect(view().name("contents/newBook.book-main")) // view name은 contents/newBook.book-main
				.andExpect(model().attributeExists("bookList")) // model attribute로 bookList 포함
				.andExpect(model().attribute("bookList",contains(book))); // model attribute의 bookList에 book 포함 확인
				
	}
}
