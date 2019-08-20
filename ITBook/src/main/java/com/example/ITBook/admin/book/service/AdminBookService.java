package com.example.ITBook.admin.book.service;

import java.util.List;

import com.example.ITBook.domain.Bcategory;
import com.example.ITBook.domain.Book;
import com.example.ITBook.domain.Scategory;

public interface AdminBookService {

	List<Bcategory> selectParentCategoryList() throws Exception;

	List<Scategory> selectChildCategoryList(Bcategory parent) throws Exception;

	boolean insertBook(Book book, long category1, long cateogry2) throws Exception;

	
}
