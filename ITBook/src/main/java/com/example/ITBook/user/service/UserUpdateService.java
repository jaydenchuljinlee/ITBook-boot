package com.example.ITBook.user.service;

import com.example.ITBook.common.domain.User;

public interface UserUpdateService {

	boolean checkIdAndPassword(User user) throws Exception;

}
