package com.example.ITBook.admin.book.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ITBook.common.domain.Bcategory;
import com.example.ITBook.common.domain.Scategory;

public interface AdminSmallCategoryRepository  extends JpaRepository<Scategory, Long>{
	
	public List<Scategory> findAll();
	
	public List<Scategory> findByBcategory(Bcategory parent);

}
