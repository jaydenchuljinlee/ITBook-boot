package com.example.ITBook.myPage.myBasket.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ITBook.domain.MyBasket;
import com.example.ITBook.domain.User;
import com.example.ITBook.domain.pk.MyBasketPK;

@Repository
public interface MyBasketRepository extends JpaRepository<MyBasket, MyBasketPK>{

	List<MyBasket> findAllByUser(User user)throws Exception;


}
