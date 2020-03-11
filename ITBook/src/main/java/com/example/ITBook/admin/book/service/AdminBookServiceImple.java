package com.example.ITBook.admin.book.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

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
import com.example.ITBook.common.domain.Bookcategory;
import com.example.ITBook.common.domain.Hashtag;
import com.example.ITBook.common.domain.Scategory;
import com.example.ITBook.common.domain.Tag;

@Transactional
@Service
public class AdminBookServiceImple implements AdminBookService {
	private static final Logger logger = LoggerFactory.getLogger(AdminBookServiceImple.class);
	
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

	/*
	 * @param 			: book(책 객체), category1(부모 카테고리), category2(자식 카테고리), hash(해시 태그 정보)
	 * @return			: 등록 성공 여부
	 * @isBookPresent()	: 책 존재 여부
	 */
	@Override
	public boolean insertBook(Book book, long category1, long category2,List<Long> hash) throws Exception {
		
		Optional<Book> list =  bookRegisterRepository.findById(book.getIsbn());
		
		if (isBookPresent(list)) {
			return true;
		}
		
		bookAndCategoryAndhashSave(book,category1,category2,hash);
		
		return false;
		
	}

	/*
	 * @param 				: book(책 객체), category1(부모 카테고리), category2(자식 카테고리), hash(해시 태그 정보)
	 * @categoryCreate()	: 카테고리 객체 생성
	 * @setBookCategory()	: 책 객체에 카테고리 객체 매핑
	 * @setBookhashtag()	: 책 객체에 해시태그 객체 매핑
	 * @repositorySave()	: 디비에 저장
	 */
	private void bookAndCategoryAndhashSave(Book book, long category1, long category2,List<Long> hash) {
		
		Scategory child = categoryCreate(category1,category2);
		
		Bookcategory categoryInfo = setBookCategory(book,child);

		List<Hashtag> tagInfos = new ArrayList<>();
		
		if (hash != null) tagInfos = setBookhashtag(book,hash);
		
		repositorySave(book,categoryInfo,tagInfos);
		
	}

	/*
	 * @param 			: book(책 객체), categoryInfo(부모 카테고리), tagInfo(해시 태그 정보)
	 */
	private void repositorySave(Book book, Bookcategory categoryInfo, List<Hashtag> tagInfo) {
		
		
		bookRegisterRepository.save(book);
		
		if (tagInfo != null) {
			for (Hashtag item: tagInfo) bookHashtageRepository.save(item);
		}
		
		bookCategoryRepository.save(categoryInfo);
		
	}

	/*
	 * @param 	: book(책 객체), hash(해시 태그 정보)
	 * @return	: 해시태그 리스트	
	 */
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
