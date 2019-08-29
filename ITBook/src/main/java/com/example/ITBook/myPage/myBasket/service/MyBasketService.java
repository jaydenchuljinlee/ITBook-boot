package com.example.ITBook.myPage.myBasket.service;

import java.util.List;
import java.util.Map;

import com.example.ITBook.domain.MyBasket;
import com.example.ITBook.domain.User;

public interface MyBasketService {

	boolean insertMyBasket(long isbn,long userIdx) throws Exception;

	List<MyBasket> selectByUser(Long index) throws Exception;

	Map<String ,String> deleteMyBasket(long param, User user) throws Exception;

}
