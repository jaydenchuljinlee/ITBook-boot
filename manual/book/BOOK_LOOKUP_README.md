책 관련 정보
-
책 객체 생성, 책 정보 등록, 책 정보 조회, 책 정보 변경

책 정보 조회
-
- 책 정보 조회는 메인 페이지와 관리 페이지에서 조회할 수 있는데,
  메인 페이지의 서비스는 New도서/Best도서라는 서비스를 구현하였습니다.
  
  -> 먼저 메인 관련 책 controller에서 New도서/Best도서 중에 Request를 받고
  -> JPA 기본 특성에서는 이 쿼리문을 지원해주지 않기 때문에 
  -> 서비스에서 JPQL과 EntityManager라는 영속성 관리 Class를 통해 쿼리문을 작성해 줬습니다.
  
- 책 메인 -> New도서/Best도서 controller [BookWebController.java] 

```java
package com.example.ITBook.book.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.ITBook.book.service.BookService;
import com.example.ITBook.common.domain.Book;

import lombok.Getter;

@Controller
@SessionAttributes("user")
@RequestMapping(value = "/book")
public class BookWebController {
	private static final Logger logger = LoggerFactory.getLogger(BookWebController.class);
	
	@Autowired
	private BookService bookService;

	/*
	 * @info	: 책 메인 페이지
	 * @param 	: model
	 * @return	: 책 메인 페이지
	 */
	@GetMapping()
	public String book(Model model) throws Exception{
		
		List<Book> list = bookService.selectBookListAll();
		
		model.addAttribute("bookList", list);
		
		return "contents/newBook.book-main";
	}
	
	/*
	 * @info	: 추천 책 페이지
	 * @param 	: model
	 * @return	: 추천 책 페이지
	 */
	@RequestMapping(value = "/recommendBook")
	public String recommendBook(Model model) throws Exception{
		
		List<Book> list = bookService.selectBestBookList();
		
		model.addAttribute("bookList", list);
		
		return "contents/recommendBook.book-main";
	}
}
```
- New도서/Best도서 service [BookServiceImple.java] 

```java

package com.example.ITBook.book.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ITBook.book.repository.BookRepository;
import com.example.ITBook.common.domain.Book;
import com.example.ITBook.common.domain.PaymentInformation;

import lombok.Getter;

@Transactional
@Service
public class BookServiceImple implements BookService {

	@Getter
	@PersistenceContext
	private EntityManager em;// 영속성 컨텍스트 객체
	
	@Autowired
	private BookRepository bookRepository;//책 객체 관련 리파지토리
	
	@Override
	public List<Book> selectBookListAll() throws Exception {
		
		return bookRepository.findAll();
	}

	/*
	 * @query 	: JPQL을 통한 쿼리 생성 후 책 정보를 내림차순으로 정렬한 쿼리
	 * 			: setMaxResults(7) 메서드를 통해 7개 까지만 뽑아 옴
	 * @return	: 책 정보
	 * */
	@Override
	public List<Book> selectNewBookList() throws Exception {

		
		String jpql = "SELECT b " + "FROM Book b " + "ORDER BY publishdate DESC";
		TypedQuery<Book> query = em.createQuery(jpql, Book.class);
		query.setMaxResults(7);
		 
		List<Book> bookList = query.getResultList();
		
		return bookList;
	}

	/*
	 * @query 	: JPQL을 통한 책 구매 리스트 쿼리 생성 후 책 정보를 판매량 순으로 내림차순으로 정렬한 쿼리
	 * 			: setMaxResults(7) 메서드를 통해 7개 까지만 뽑아 옴
	 * @return	: 책 정보
	 * */
	@Override
	public List<Book> selectBestBookList() throws Exception {

		
		String jpql = "SELECT payInfo.book " + "FROM PaymentInformation payInfo " +
					"GROUP BY payInfo.book " + "ORDER BY count(payInfo.book) DESC";
		TypedQuery<Book> query = em.createQuery(jpql, Book.class);
		query.setMaxResults(7);
		
		 List<Book> bookList = query.getResultList();
		
		return bookList;
	}

}


```
