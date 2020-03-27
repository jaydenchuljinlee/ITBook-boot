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

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Transactional
@Service
public class AdminBookServiceImple implements AdminBookService {
	
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
		
		log.info("AdminBookServiceImple.selectAllBooks :::");
		
		return adminBookRepository.findAll();
	}

	@Override
	public List<Bcategory> selectParentCategoryList() throws Exception {
		
		log.info("AdminBookServiceImple.selectParentCategoryList :::");
		
		return bCategoryRepository.findAll();
	}

	@Override
	public List<Scategory> selectChildCategoryList(Bcategory parent) throws Exception {
		
		log.info("AdminBookServiceImple.selectChildCategoryList :::");
		
		return sCategoryRepository.findByBcategory(parent);
	}

	/*
	 * @param 			: book(å ��ü), category1(�θ� ī�װ�), category2(�ڽ� ī�װ�), hash(�ؽ� �±� ����)
	 * @return			: ��� ���� ����
	 * @isBookPresent()	: å ���� ����
	 */
	@Override
	public boolean insertBook(Book book, long category1, long category2,List<Long> hash) throws Exception {
		
		log.info("AdminBookServiceImple.insertBook :::");
		
		Optional<Book> list =  bookRegisterRepository.findById(book.getIsbn());
		
		if (isBookPresent(list)) {
			return false;
		}
		
		bookAndCategoryAndhashSave(book,category1,category2,hash);
		
		return adminBookRepository.existsById(book.getIsbn()) ? true : false;
		
	}

	/*
	 * @param 				: book(å ��ü), category1(�θ� ī�װ�), category2(�ڽ� ī�װ�), hash(�ؽ� �±� ����)
	 * @categoryCreate()	: ī�װ� ��ü ����
	 * @setBookCategory()	: å ��ü�� ī�װ� ��ü ����
	 * @setBookhashtag()	: å ��ü�� �ؽ��±� ��ü ����
	 * @repositorySave()	: ��� ����
	 */
	private void bookAndCategoryAndhashSave(Book book, long category1, long category2,List<Long> hash) {
		
		log.info("AdminBookServiceImple.bookAndCategoryAndhashSave :::");
		
		Scategory child = categoryCreate(category1,category2);
		
		Bookcategory categoryInfo = setBookCategory(book,child);

		List<Hashtag> tagInfos = new ArrayList<>();
		
		if (hash != null) tagInfos = setBookhashtag(book,hash);
		
		repositorySave(book,categoryInfo,tagInfos);
		
	}

	/*
	 * @param 			: book(å ��ü), categoryInfo(�θ� ī�װ�), tagInfo(�ؽ� �±� ����)
	 */
	private void repositorySave(Book book, Bookcategory categoryInfo, List<Hashtag> tagInfo) {
		
		log.info("AdminBookServiceImple.repositorySave :::");
		
		bookRegisterRepository.save(book);
		
		if (tagInfo != null) {
			for (Hashtag item: tagInfo) bookHashtageRepository.save(item);
		}
		
		bookCategoryRepository.save(categoryInfo);
		
	}

	/*
	 * @param 	: book(å ��ü), hash(�ؽ� �±� ����)
	 * @return	: �ؽ��±� ����Ʈ	
	 */
	private List<Hashtag> setBookhashtag(Book book,List<Long> hash) {
		
		log.info("AdminBookServiceImple.setBookhashtag :::");
		
		List<Hashtag> tagInfos = new ArrayList<Hashtag>();
		
		for (long code : hash) {
			Tag tag = Tag.builder()
						.code(code)
						.build();
			
			Hashtag hashtag = Hashtag.builder()
									.book(book)
									.tag(tag)
									.build();
			
			tagInfos.add(hashtag);
		}
		
		return tagInfos;
	}
	
	/*
	 * @info	: å ���� ���� �˻�
	 * @param 	: book(å ��ü), hash(�ؽ� �±� ����)
	 * @return	: �ؽ��±� ����Ʈ	
	 */
	@Override
	public Optional<Book> selectBookByIsbn(Book book) throws Exception {
		
		log.info("AdminBookServiceImple.selectBookByIsbn :::");
		
		return adminBookRepository.findById(book.getIsbn());
	}

	private Bookcategory setBookCategory(Book book, Scategory child) {

		log.info("AdminBookServiceImple.setBookCategory :::");
		
		book.setS_category(child);
		
		return new Bookcategory(book,child);
	}

	private Scategory categoryCreate(long category1, long category2) {

		log.info("AdminBookServiceImple.categoryCreate :::");
		
		Bcategory parent = Bcategory.builder()
									.code(category1)
									.build();
		
		Scategory child = Scategory.builder()
									.bcategory(parent)
									.code(category2)
									.build();
		
		return child;
		
	}

	private boolean isBookPresent(Optional<Book> list) {
		
		log.info("AdminBookServiceImple.isBookPresent :::");
		
		return list.isPresent();
	}

	

	

	

}
