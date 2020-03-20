package com.example.ITBook.myPage.myBasket.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.example.ITBook.common.domain.MyBasket;
import com.example.ITBook.common.domain.User;

public interface MyBasketService {

	Optional<MyBasket> insertMyBasket(long isbn,long userIdx) throws Exception;

	List<MyBasket> selectByUser(Long index) throws Exception;

	Optional<MyBasket> deleteMyBasket(long param, User user) throws Exception;

}
