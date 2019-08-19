package com.example.ITBook.admin.book.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ITBook.domain.BCategory;

public interface AdminBigCategoryRepository  extends JpaRepository<BCategory, Long>{
	
	public List<BCategory> findAll();
	
	public List<BCategory> findByCode(long Code);

}
