package com.example.ITBook.user.service;

import java.util.Optional;

import com.example.ITBook.common.domain.User;

public interface UserUpdateService {

	boolean checkIdAndPassword(User user) throws Exception;

	Optional<User> deleteUser(User user) throws Exception;

	Optional<User> updateUser(User user) throws Exception;

}
