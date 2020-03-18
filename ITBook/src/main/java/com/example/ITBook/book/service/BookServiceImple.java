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
	private EntityManager em;// ���Ӽ� ���ؽ�Ʈ ��ü
	
	@Autowired
	private BookRepository bookRepository;//å ��ü ���� �������丮
	
	@Override
	public List<Book> selectBookListAll() throws Exception {
		
		return bookRepository.findAll();
	}

	/*
	 * @query 	: JPQL�� ���� ���� ���� �� å ������ ������������ ������ ����
	 * 			: setMaxResults(7) �޼��带 ���� 7�� ������ �̾� ��
	 * @return	: å ����
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
	 * @query 	: JPQL�� ���� å ���� ����Ʈ ���� ���� �� å ������ �Ǹŷ� ������ ������������ ������ ����
	 * 			: setMaxResults(7) �޼��带 ���� 7�� ������ �̾� ��
	 * @return	: å ����
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
