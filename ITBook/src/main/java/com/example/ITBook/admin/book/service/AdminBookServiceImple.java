package com.example.ITBook.admin.book.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.ITBook.admin.book.repository.AdminBigCategoryRepository;
import com.example.ITBook.admin.book.repository.AdminSmallCategoryRepository;
import com.example.ITBook.domain.BCategory;
import com.example.ITBook.domain.SCategory;

@Service
public class AdminBookServiceImple implements AdminBookService {
	
	private AdminBigCategoryRepository bCategoryRepository;
	private AdminSmallCategoryRepository sCategoryRepository;
	
	public AdminBookServiceImple(AdminBigCategoryRepository bCategoryRepository
			,AdminSmallCategoryRepository sCategoryRepository) {
		this.bCategoryRepository = bCategoryRepository;
		this.sCategoryRepository = sCategoryRepository;
	}

	@Override
	public List<BCategory> selectParentCategoryList() throws Exception {
		
		return bCategoryRepository.findAll();
	}

	@Override
	public List<SCategory> selectChildCategoryList(BCategory parent) throws Exception {
		
		return sCategoryRepository.findByBCategory(parent);
	}

}
