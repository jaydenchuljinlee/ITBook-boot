package com.example.ITBook.admin.book.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.ITBook.admin.book.repository.AdminBigCategoryRepository;
import com.example.ITBook.admin.book.repository.AdminBookCategoryRepository;
import com.example.ITBook.admin.book.repository.AdminBookRegisterRepository;
import com.example.ITBook.admin.book.repository.AdminSmallCategoryRepository;
import com.example.ITBook.domain.Bcategory;
import com.example.ITBook.domain.Book;
import com.example.ITBook.domain.Scategory;

@Service
public class AdminBookServiceImple implements AdminBookService {
	
	private AdminBigCategoryRepository bCategoryRepository;
	private AdminSmallCategoryRepository sCategoryRepository;
	private AdminBookRegisterRepository bookRegisterRepository;
	private AdminBookCategoryRepository bookCategoryRepository;
	
	public AdminBookServiceImple(AdminBigCategoryRepository bCategoryRepository
			,AdminSmallCategoryRepository sCategoryRepository
			,AdminBookRegisterRepository bookRegisterRepository
			,AdminBookCategoryRepository bookCategoryRepository) {
		this.bCategoryRepository = bCategoryRepository;
		this.sCategoryRepository = sCategoryRepository;
		this.bookRegisterRepository = bookRegisterRepository;
		this.bookCategoryRepository = bookCategoryRepository;
	}

	@Override
	public List<Bcategory> selectParentCategoryList() throws Exception {
		
		return bCategoryRepository.findAll();
	}

	@Override
	public List<Scategory> selectChildCategoryList(Bcategory parent) throws Exception {
		
		return sCategoryRepository.findByBcategory(parent);
	}

	@Override
	public boolean insertBook(Book book, long category1, long category2) throws Exception {
		
		Optional<Book> list =  bookRegisterRepository.findById(book.getIsbn());
		
		if (isBookPresent(list)) {
			return true;
		}
		
		Bcategory parent = new Bcategory(category1);
		
		Scategory child = new Scategory(category2,parent);
		
		book.setS_category(child);
		
		bookRegisterRepository.save(book);
		
		return false;
		
	}

	private boolean isBookPresent(Optional<Book> list) {
		
		return list.isPresent();
	}
	
	


}
