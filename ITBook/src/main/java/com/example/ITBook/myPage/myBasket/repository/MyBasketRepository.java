package com.example.ITBook.myPage.myBasket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ITBook.domain.MyBasket;
import com.example.ITBook.domain.pk.MyBasketPK;

public interface MyBasketRepository extends JpaRepository<MyBasket, MyBasketPK>{

}
