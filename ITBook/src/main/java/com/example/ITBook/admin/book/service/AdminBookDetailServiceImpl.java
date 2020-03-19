package com.example.ITBook.admin.book.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ITBook.admin.book.repository.AdminBigCategoryRepository;
import com.example.ITBook.admin.book.repository.AdminBookCategoryRepository;
import com.example.ITBook.admin.book.repository.AdminBookHashtageRepository;
import com.example.ITBook.admin.book.repository.AdminBookRegisterRepository;
import com.example.ITBook.admin.book.repository.AdminBookRepository;
import com.example.ITBook.admin.book.repository.AdminSmallCategoryRepository;
import com.example.ITBook.common.domain.Bcategory;
import com.example.ITBook.common.domain.Book;
import com.example.ITBook.common.domain.pk.BookCategoryPK;
import com.example.ITBook.common.domain.Bookcategory;
import com.example.ITBook.common.domain.Scategory;
import com.example.ITBook.common.domain.pk.CategoryPK;

@Service
public class AdminBookDetailServiceImpl implements AdminBookDetailService {
	private static final Logger logger = LoggerFactory.getLogger(AdminBookDetailServiceImpl.class);
	
	@Autowired
	private AdminBigCategoryRepository bCategoryRepository;
	@Autowired
	private AdminSmallCategoryRepository sCategoryRepository;
	@Autowired
	private AdminBookRegisterRepository bookRegisterRepository;
	@Autowired
	private AdminBookCategoryRepository bookCategoryRepository;
	@Autowired
	private AdminBookHashtageRepository bookHashtageRepository;
	@Autowired
	private AdminBookRepository adminBookRepository;
	
	/*
	 * @param 			:  isbn(å ��ȣ)
	 * @return			: ��� ���� ����
	 * @isBook()		: å�� ��� �Ǿ� �ִ��� �˻�, map(���� ����), book(å ��ü)
	 * @createMapData	: å ���, map, book, category1, category2
	 */
	@Override
	public Map<String, Object> selectBookAndCategory(long isbn) throws Exception {
		
		//å ��� ���� ����
		Map<String, Object> map =  new HashMap<String, Object>();
		
		Optional<Book> book = bookRegisterRepository.findById(isbn);
		
		//å�� DB�� ���� �Ǿ� �ִ��� �˻�
		if (isBook(map,book)) {
			
			Bcategory parent = book.get().getS_category().getBcategory(); 
			
			List category1 = bCategoryRepository.findAll();
			
			List category2 = sCategoryRepository.findByBcategory(parent);
			
			//���� �Ǿ� ���� ��, å ���
			createMapData(map,book,category1,category2);
		}
		
		return map;
	}
	
	/*
	 * @param 			:  map(��� ���� ����), book(å ��ü)
	 * @return			: ��� ���� ����
	 */
	private boolean isBook(Map<String, Object> map, Optional<Book> book) {
		
		return book.isPresent();
	}

	/*
	 * @param 			:  map(��� ���� ����), book(å ��ü) , category1(�θ� ī��), category2(�ڽ� ī��)
	 */
	private void createMapData(Map<String, Object> map, Optional<Book> book, List category1, List category2) {

		map.put("book", book.get());
		map.put("b_category", book.get().getS_category().getBcategory());
		map.put("s_category", book.get().getS_category());
		map.put("category1", category1);
		map.put("category2", category2);
		
	}
	
	/*
	 * @param 				: book(å ��ü) , category1(�θ� ī��), category2(�ڽ� ī��)
	 * 							, isChangeB(å ���� ����), isChangeC(ī�װ� ���� ����)
	 * @categoryCreate()	: ī�װ� Ȯ���� ���� ī�װ� ���� �޼���
	 * @selectRepository()	: å�� ī�װ� ��ȸ �� ������Ʈ
	 */
	@Override
	public void updateBookInfo(Book book, long category1, long category2,boolean isChangeB,boolean isChangeC) throws Exception {
		
		BookCategoryPK categoryInfo = new BookCategoryPK(book.getIsbn(),category2);
		
		Scategory child = categoryCreate(category1,category2);
		
		selectRepository(book,categoryInfo,child,isChangeB,isChangeC);
		
	}

	/*
	 * @param 					: book(å ��ü) ,categoryInfo(ī�װ� ����), child(�ڽ� ī�� ��ü)
	 * 								, isChangeB(å ���� ����), isChangeC(ī�װ� ���� ����)
	 * @OnlyChangeCategory()	: ī�װ��� ���� ����
	 * @OnlyChangeBook()		: å�� ���� ����
	 * @repositorySave()		: å��, ī�װ� ����
	 * @setBookCategory()		: å ������ ���� å ��ü�� ī�װ� ������ �Է�
	 */
	private void selectRepository(Book book, BookCategoryPK categoryInfo, Scategory child, boolean isChangeB,
			boolean isChangeC) {

		if(OnlyChangeCategory(isChangeB,isChangeC)) {
			
			bookCategoryRepository.deleteByBook(book);
			
			Bookcategory bookCategory = setBookCategory(book,child);
			
			bookCategoryRepository.saveAndFlush(bookCategory);
			
		} else if(OnlyChangeBook(isChangeB,isChangeC)) {
			
			adminBookRepository.saveAndFlush(book);
		} else {
			
			bookCategoryRepository.deleteByBook(book);
			
			Bookcategory bookCategory = setBookCategory(book,child);
			
			repositorySave(book,bookCategory);
		}
		
	}

	private boolean OnlyChangeBook(boolean isChangeB, boolean isChangeC) {
		
		return isChangeB && !isChangeC;
	}

	private boolean OnlyChangeCategory(boolean isChangeB, boolean isChangeC) {
		
		return !isChangeB && isChangeC;
	}

	private void repositorySave(Book book, Bookcategory bookCategory) {
		
		bookCategoryRepository.save(bookCategory);

		adminBookRepository.saveAndFlush(book);
		
	}

	private Bookcategory setBookCategory(Book book, Scategory child) {

		book.setS_category(child);
		
		return new Bookcategory(book,child);
	}

	private Scategory categoryCreate(long category1, long category2) {
		
		return new Scategory(category2,new Bcategory(category1));
	}

	

	

	

}
