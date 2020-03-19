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
	 * @param 			:  isbn(책 번호)
	 * @return			: 등록 성공 여부
	 * @isBook()		: 책이 등록 되어 있는지 검사, map(성공 여부), book(책 객체)
	 * @createMapData	: 책 등록, map, book, category1, category2
	 */
	@Override
	public Map<String, Object> selectBookAndCategory(long isbn) throws Exception {
		
		//책 등록 성공 여부
		Map<String, Object> map =  new HashMap<String, Object>();
		
		Optional<Book> book = bookRegisterRepository.findById(isbn);
		
		//책이 DB에 저장 되어 있는지 검사
		if (isBook(map,book)) {
			
			Bcategory parent = book.get().getS_category().getBcategory(); 
			
			List category1 = bCategoryRepository.findAll();
			
			List category2 = sCategoryRepository.findByBcategory(parent);
			
			//저장 되어 있을 시, 책 등록
			createMapData(map,book,category1,category2);
		}
		
		return map;
	}
	
	/*
	 * @param 			:  map(등록 성공 여부), book(책 객체)
	 * @return			: 등록 성공 여부
	 */
	private boolean isBook(Map<String, Object> map, Optional<Book> book) {
		
		return book.isPresent();
	}

	/*
	 * @param 			:  map(등록 성공 여부), book(책 객체) , category1(부모 카테), category2(자식 카테)
	 */
	private void createMapData(Map<String, Object> map, Optional<Book> book, List category1, List category2) {

		map.put("book", book.get());
		map.put("b_category", book.get().getS_category().getBcategory());
		map.put("s_category", book.get().getS_category());
		map.put("category1", category1);
		map.put("category2", category2);
		
	}
	
	/*
	 * @param 				: book(책 객체) , category1(부모 카테), category2(자식 카테)
	 * 							, isChangeB(책 변경 여부), isChangeC(카테고리 변경 여부)
	 * @categoryCreate()	: 카테고리 확인을 위한 카테고리 생성 메서드
	 * @selectRepository()	: 책과 카테고리 조회 후 업데이트
	 */
	@Override
	public void updateBookInfo(Book book, long category1, long category2,boolean isChangeB,boolean isChangeC) throws Exception {
		
		BookCategoryPK categoryInfo = new BookCategoryPK(book.getIsbn(),category2);
		
		Scategory child = categoryCreate(category1,category2);
		
		selectRepository(book,categoryInfo,child,isChangeB,isChangeC);
		
	}

	/*
	 * @param 					: book(책 객체) ,categoryInfo(카테고리 정보), child(자식 카테 객체)
	 * 								, isChangeB(책 변경 여부), isChangeC(카테고리 변경 여부)
	 * @OnlyChangeCategory()	: 카테고리만 변경 여부
	 * @OnlyChangeBook()		: 책만 변경 여부
	 * @repositorySave()		: 책과, 카테고리 저장
	 * @setBookCategory()		: 책 저장을 위해 책 객체에 카테고리 정보를 입력
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
