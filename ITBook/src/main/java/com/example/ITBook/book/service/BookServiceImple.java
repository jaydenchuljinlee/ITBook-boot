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

		/*
		 * String jpql = "SELECT b " + "FROM Book b " + "ORDER BY publishdate DESC";
		 * TypedQuery<Book> query = em.createQuery(jpql, Book.class);
		 * query.setMaxResults(7);
		 * 
		 * List<Book> bookList = query.getResultList();
		 */
		
		List<Book> bookList = bookRepository.seleteNewbookList();
		
		return bookList;
	}

	/*
	 * @query 	: JPQL을 통한 책 구매 리스트 쿼리 생성 후 책 정보를 판매량 순으로 내림차순으로 정렬한 쿼리
	 * 			: setMaxResults(7) 메서드를 통해 7개 까지만 뽑아 옴
	 * @return	: 책 정보
	 * */
	@Override
	public List<Book> selectBestBookList() throws Exception {

		/*
		 * String jpql = "SELECT payInfo.book " + "FROM PaymentInformation payInfo " +
		 * "GROUP BY payInfo.book " + "ORDER BY count(payInfo.book) DESC";
		 * TypedQuery<Book> query = em.createQuery(jpql, Book.class);
		 * query.setMaxResults(7);
		 * 
		 * List<Book> bookList = query.getResultList();
		 */
		
		List<Book> bookList = bookRepository.seleteBestbookList();
		
		return bookList;
	}

}
