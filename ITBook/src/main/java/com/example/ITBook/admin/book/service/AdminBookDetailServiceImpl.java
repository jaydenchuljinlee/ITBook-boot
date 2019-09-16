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
import com.example.ITBook.domain.Bcategory;
import com.example.ITBook.domain.Book;
import com.example.ITBook.domain.BookCategoryPK;
import com.example.ITBook.domain.Bookcategory;
import com.example.ITBook.domain.Scategory;
import com.example.ITBook.domain.pk.CategoryPK;

@Service
public class AdminBookDetailServiceImpl implements AdminBookDetailService {
	private static final Logger logger = LoggerFactory.getLogger(AdminBookDetailServiceImpl.class);
	
	private AdminBigCategoryRepository bCategoryRepository;
	private AdminSmallCategoryRepository sCategoryRepository;
	private AdminBookRegisterRepository bookRegisterRepository;
	private AdminBookCategoryRepository bookCategoryRepository;
	private AdminBookHashtageRepository bookHashtageRepository;
	private AdminBookRepository adminBookRepository;
	
	@Autowired
	public AdminBookDetailServiceImpl(AdminBigCategoryRepository bCategoryRepository
			,AdminSmallCategoryRepository sCategoryRepository
			,AdminBookRegisterRepository bookRegisterRepository
			,AdminBookCategoryRepository bookCategoryRepository
			,AdminBookHashtageRepository bookHashtageRepository
			,AdminBookRepository adminBookRepository) {
		
		this.bCategoryRepository = bCategoryRepository;
		this.sCategoryRepository = sCategoryRepository;
		this.bookRegisterRepository = bookRegisterRepository;
		this.bookCategoryRepository = bookCategoryRepository;
		this.bookHashtageRepository = bookHashtageRepository;
		this.adminBookRepository = adminBookRepository;
	}
	
	@Override
	public Map<String, Object> selectBookAndCategory(long isbn) throws Exception {
		
		Map<String, Object> map =  new HashMap<String, Object>();
		
		Optional<Book> book = bookRegisterRepository.findById(isbn);
		
		if (isBook(map,book)) {
			
			Bcategory parent = book.get().getS_category().getBcategory(); 
			
			List category1 = bCategoryRepository.findAll();
			
			List category2 = sCategoryRepository.findByBcategory(parent);
			
			createMapData(map,book,category1,category2);
		}
		
		return map;
	}
	
	private boolean isBook(Map<String, Object> map, Optional<Book> book) {
		
		return book.isPresent();
	}

	private void createMapData(Map<String, Object> map, Optional<Book> book, List category1, List category2) {

		map.put("book", book.get());
		map.put("b_category", book.get().getS_category().getBcategory());
		map.put("s_category", book.get().getS_category());
		map.put("category1", category1);
		map.put("category2", category2);
		
	}
	
	@Override
	public void updateBookInfo(Book book, long category1, long category2,boolean isChangeB,boolean isChangeC) throws Exception {
		
		BookCategoryPK categoryInfo = new BookCategoryPK(book.getIsbn(),category2);
		
		Scategory child = categoryCreate(category1,category2);
		
		selectRepository(book,categoryInfo,child,isChangeB,isChangeC);
		
	}

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
		
		return isChangeB && isChangeC;
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
