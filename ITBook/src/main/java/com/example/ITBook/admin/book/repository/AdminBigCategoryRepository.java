package com.example.ITBook.admin.book.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ITBook.domain.Bcategory;

public interface AdminBigCategoryRepository  extends JpaRepository<Bcategory, Long>{
	
	public List<Bcategory> findAll();
	
	public List<Bcategory> findByCode(long Code);

}
