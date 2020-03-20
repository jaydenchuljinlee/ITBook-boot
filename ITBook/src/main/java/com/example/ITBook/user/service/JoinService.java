package com.example.ITBook.user.service;

import java.util.Optional;

import com.example.ITBook.common.domain.User;

public interface JoinService {

	Optional<User> insertUser(User user) throws Exception;

}
