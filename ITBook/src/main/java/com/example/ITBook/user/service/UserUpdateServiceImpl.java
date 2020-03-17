package com.example.ITBook.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ITBook.common.domain.User;
import com.example.ITBook.user.repository.UserRepository;

@Service
public class UserUpdateServiceImpl implements UserUpdateService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public boolean checkIdAndPassword(User user) throws Exception {

		
		return false;
	}
}
