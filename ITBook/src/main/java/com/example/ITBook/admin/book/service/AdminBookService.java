package com.example.ITBook.admin.book.service;

import java.util.List;

import com.example.ITBook.domain.BCategory;
import com.example.ITBook.domain.SCategory;

public interface AdminBookService {

	List<BCategory> selectParentCategoryList() throws Exception;

	List<SCategory> selectChildCategoryList(BCategory parent) throws Exception;

	
}
