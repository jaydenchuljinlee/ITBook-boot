package com.example.ITBook.admin.book.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.ITBook.admin.book.repository.AdminBigCategoryRepository;
import com.example.ITBook.admin.book.repository.AdminBookCategoryRepository;
import com.example.ITBook.admin.book.repository.AdminBookHashtageRepository;
import com.example.ITBook.admin.book.repository.AdminBookRegisterRepository;
import com.example.ITBook.admin.book.repository.AdminBookRepository;
import com.example.ITBook.admin.book.repository.AdminSmallCategoryRepository;
import com.example.ITBook.domain.Bcategory;
import com.example.ITBook.domain.Book;
import com.example.ITBook.domain.Bookcategory;
import com.example.ITBook.domain.Hashtag;
import com.example.ITBook.domain.Scategory;
import com.example.ITBook.domain.Tag;

@Transactional
@Service
public class AdminBookServiceImple implements AdminBookService {
	
	private AdminBigCategoryRepository bCategoryRepository;
	private AdminSmallCategoryRepository sCategoryRepository;
	private AdminBookRegisterRepository bookRegisterRepository;
	private AdminBookCategoryRepository bookCategoryRepository;
	private AdminBookHashtageRepository bookHashtageRepository;
	private AdminBookRepository adminBookRepository;
	
	public AdminBookServiceImple(AdminBigCategoryRepository bCategoryRepository
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
	public List<Book> selectAllBooks() throws Exception {
		
		return adminBookRepository.findAll();
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
	public boolean insertBook(Book book, long category1, long category2,List<Long> hash) throws Exception {
		
		Optional<Book> list =  bookRegisterRepository.findById(book.getIsbn());
		
		if (isBookPresent(list)) {
			return true;
		}
		
		bookAndCategoryAndhashSave(book,category1,category2,hash);
		
		return false;
		
	}

	private void bookAndCategoryAndhashSave(Book book, long category1, long category2,List<Long> hash) {
		
		Scategory child = categoryCreate(category1,category2);
		
		Bookcategory categoryInfo = setBookCategory(book,child);

		List<Hashtag> tagInfos = setBookhashtag(book,hash);
		
		repositorySave(book,categoryInfo,tagInfos);
		
	}

	private void repositorySave(Book book, Bookcategory categoryInfo, List<Hashtag> tagInfo) {
		
		
		bookRegisterRepository.save(book);
		
		for (Hashtag item: tagInfo) {
			bookHashtageRepository.save(item);
		}
		
		
		
		bookCategoryRepository.save(categoryInfo);
		
	}

	private List<Hashtag> setBookhashtag(Book book,List<Long> hash) {
		
		List<Hashtag> tagInfos = new ArrayList<Hashtag>();
		
		for (long code : hash) {
			Tag tag = new Tag(code);
			tagInfos.add(new Hashtag(book,tag));
		}
		
		return tagInfos;
	}

	private Bookcategory setBookCategory(Book book, Scategory child) {

		book.setS_category(child);
		
		return new Bookcategory(book,child);
	}

	private Scategory categoryCreate(long category1, long category2) {

		Bcategory parent = new Bcategory(category1);
		
		Scategory child = new Scategory(category2,parent);
		
		return child;
		
	}

	private boolean isBookPresent(Optional<Book> list) {
		
		return list.isPresent();
	}

	

	

}
