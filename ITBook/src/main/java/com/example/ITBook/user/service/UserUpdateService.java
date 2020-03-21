package com.example.ITBook.user.service;

import java.util.Optional;

import com.example.ITBook.common.domain.User;

public interface UserUpdateService {

	Optional<User> checkIdAndPassword(User user) throws Exception;

	boolean deleteUser(User user) throws Exception;

	boolean updateUser(User user) throws Exception;

}
