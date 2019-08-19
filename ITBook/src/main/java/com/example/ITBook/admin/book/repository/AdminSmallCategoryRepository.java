package com.example.ITBook.admin.book.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ITBook.domain.BCategory;
import com.example.ITBook.domain.SCategory;


public interface AdminSmallCategoryRepository  extends JpaRepository<SCategory, Long>{
	
	public List<SCategory> findAll();
	
	public List<SCategory> findByBCategory(BCategory parent);

}
