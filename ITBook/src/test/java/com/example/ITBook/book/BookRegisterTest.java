package com.example.ITBook.book;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.time.LocalDateTime;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.ITBook.admin.book.service.AdminBookServiceImple;
import com.example.ITBook.common.domain.Bcategory;
import com.example.ITBook.common.domain.Book;
import com.example.ITBook.common.domain.Scategory;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class BookRegisterTest {

	@Autowired private AdminBookServiceImple adminBookServiceImple;
	
	@Test
	public void å_���_�׽�Ʈ_�ߺ�() throws Exception {
		
		log.info("BookRegisterTest.å_���_�׽�Ʈ_�ߺ� ::: ");
		
		//Bcategory bcategory = Bcategory.builder().code(0).build();
		
		//Scategory scategory = Scategory.builder().bcategory(bcategory).code(0).build();
		
		Book book = Book.builder().isbn(Long.parseLong("12345678901234567"))
								.author("��ö��")
								.authorinfo("authorinfo")
								.contents("å ����")
								.image("url")
								.intro("intro")
								.original("original")
								.page(0)
								.price(0)
								.publish("publish")
								.publishdate(LocalDateTime.now())
								.quantity(0)
								.theme("theme")
								.translator("translator")
								.build();
		
		
		assertThat(adminBookServiceImple.insertBook(book, 0, 0, null),is(false));
		
		
	}
	
	@Test
	public void å_���_�׽�Ʈ() throws Exception {
		
		log.info("BookRegisterTest.å_���_�׽�Ʈ ::: ");
		
		//Bcategory bcategory = Bcategory.builder().code(0).build();
		
		//Scategory scategory = Scategory.builder().bcategory(bcategory).code(0).build();
		
		Book book = Book.builder().isbn(Long.parseLong("1234567890"))
								.author("��ö��")
								.authorinfo("authorinfo")
								.contents("å ����")
								.image("url")
								.intro("intro")
								.original("original")
								.page(0)
								.price(0)
								.publish("publish")
								.publishdate(LocalDateTime.now())
								.quantity(0)
								.theme("theme")
								.translator("translator")
								.build();
		
		
		assertThat(adminBookServiceImple.insertBook(book, 0, 0, null),is(true));
		
		
	}
}
