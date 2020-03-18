package com.example.ITBook.user.service;

import com.example.ITBook.common.domain.User;

public interface UserUpdateService {

	boolean checkIdAndPassword(User user) throws Exception;

	void deleteUser(User user) throws Exception;

	void updateUser(User user) throws Exception;

}
