package com.example.ITBook.myPage.myBasket.service;

import java.util.List;

import com.example.ITBook.domain.MyBasket;

public interface MyBasketService {

	boolean insertMyBasket(long isbn,long userIdx) throws Exception;

	List<MyBasket> selectByUser(Long index) throws Exception;

}
