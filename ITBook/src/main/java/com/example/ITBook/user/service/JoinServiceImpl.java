package com.example.ITBook.user.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ITBook.common.domain.User;
import com.example.ITBook.common.exception.UserEmailDuplicationException;
import com.example.ITBook.user.repository.UserRepository;

@Service
public class JoinServiceImpl implements JoinService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public Optional<User> insertUser(User user) throws Exception{

		if (userRepository.findByEmail(user.getEmail()).isPresent()) {
			
			throw new UserEmailDuplicationException(user.getEmail());
		}
		
		return userRepository.insert(user);
		
	}

}
