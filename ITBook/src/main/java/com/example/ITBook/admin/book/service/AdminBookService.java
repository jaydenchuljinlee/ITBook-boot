package com.example.ITBook.admin.book.service;

import java.util.List;
import java.util.Optional;

import com.example.ITBook.common.domain.Bcategory;
import com.example.ITBook.common.domain.Book;
import com.example.ITBook.common.domain.Scategory;

public interface AdminBookService {

	List<Bcategory> selectParentCategoryList() throws Exception;

	List<Scategory> selectChildCategoryList(Bcategory parent) throws Exception;

	boolean insertBook(Book book, long category1, long cateogry2,List<Long> hash) throws Exception;

	List<Book> selectAllBooks() throws Exception;

	Optional<Book> selectBookByIsbn(Book book) throws Exception;

	
}
