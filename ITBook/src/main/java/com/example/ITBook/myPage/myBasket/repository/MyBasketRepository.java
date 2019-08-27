package com.example.ITBook.myPage.myBasket.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ITBook.domain.MyBasket;
import com.example.ITBook.domain.pk.MyBasketPK;

public interface MyBasketRepository extends JpaRepository<MyBasket, MyBasketPK>{

	List<MyBasket> findAllByIdx(Long index)throws Exception;

}
