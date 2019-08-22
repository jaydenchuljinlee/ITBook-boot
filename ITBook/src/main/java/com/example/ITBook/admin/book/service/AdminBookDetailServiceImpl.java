package com.example.ITBook.admin.book.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.ITBook.admin.book.repository.AdminBigCategoryRepository;
import com.example.ITBook.admin.book.repository.AdminBookCategoryRepository;
import com.example.ITBook.admin.book.repository.AdminBookHashtageRepository;
import com.example.ITBook.admin.book.repository.AdminBookRegisterRepository;
import com.example.ITBook.admin.book.repository.AdminBookRepository;
import com.example.ITBook.admin.book.repository.AdminSmallCategoryRepository;
import com.example.ITBook.domain.Bcategory;
import com.example.ITBook.domain.Book;
import com.example.ITBook.domain.pk.CategoryPK;

@Service
public class AdminBookDetailServiceImpl implements AdminBookDetailService {

	private AdminBigCategoryRepository bCategoryRepository;
	private AdminSmallCategoryRepository sCategoryRepository;
	private AdminBookRegisterRepository bookRegisterRepository;
	private AdminBookCategoryRepository bookCategoryRepository;
	private AdminBookHashtageRepository bookHashtageRepository;
	private AdminBookRepository adminBookRepository;
	
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
	public void updateBookInfo(Book book, long category1, long category2, List<Long> hash) throws Exception {

		CategoryPK hashIdx = new CategoryPK(book.getIsbn());
		
		bookHashtageRepository.deleteById(hashIdx);
		
	}

	

	

	

}
