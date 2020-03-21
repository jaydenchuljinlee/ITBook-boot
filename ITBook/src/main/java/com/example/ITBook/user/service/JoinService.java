package com.example.ITBook.user.service;

import java.util.Optional;

import com.example.ITBook.common.domain.User;

public interface JoinService {

	boolean insertUser(User user) throws Exception;

	boolean findByEmail(String identity) throws Exception;

}
