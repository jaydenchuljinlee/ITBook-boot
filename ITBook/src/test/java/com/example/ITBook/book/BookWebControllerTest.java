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
	public void book_mvc_mock_�׽�Ʈ() throws Exception {
		
		//�θ� ī�װ� ����
		Bcategory bcategory = new Bcategory(1);
		
		//�ڽ� ī�װ� ����
		Scategory scategory = Scategory.builder()
								.code((long)1)
								.bcategory(bcategory).build();
		
		//book ��ü ����
		Book book = Book.builder()
				.isbn((long) 123455678)
				.price(123)
				.author("��ö��")
				.authorinfo("������")
				.contents("������")
				.image("�̹��� ���")
				.intro("��Ʈ��")
				.original("��������")
				.publish("���ǻ�")
				.quantity(1)
				.translator("����")
				.s_category(scategory)
				.theme("Hello World")
				.publishdate(LocalDateTime.now())
				.build();
		
		// bookService.selectBookListAll()�� ȣ���ϸ� Collections.singletonList(book)�� �����ϵ��� ����
		given(bookService.selectBookListAll()).willReturn(Collections.singletonList(book));
		
		mockMvc.perform(get("/book")) // /book�� get ��û
				.andExpect(status().isOk()) //���� 200 (ok)
				.andExpect(view().name("contents/newBook.book-main")) // view name�� contents/newBook.book-main
				.andExpect(model().attributeExists("bookList")) // model attribute�� bookList ����
				.andExpect(model().attribute("bookList",contains(book))); // model attribute�� bookList�� book ���� Ȯ��
				
	}
}
