package com.example.ITBook.admin.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ITBook.common.domain.Hashtag;
import com.example.ITBook.common.domain.pk.CategoryPK;

public interface AdminBookHashtageRepository extends JpaRepository<Hashtag,CategoryPK>{

}
