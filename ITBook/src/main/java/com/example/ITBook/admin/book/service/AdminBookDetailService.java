package com.example.ITBook.admin.book.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.example.ITBook.common.domain.Book;

public interface AdminBookDetailService {

	void updateBookInfo(Book book, long category1, long category2,boolean isChangeB,boolean isChangeC)throws Exception;

	Map<String, Object> selectBookAndCategory(long isbn) throws Exception;


}
