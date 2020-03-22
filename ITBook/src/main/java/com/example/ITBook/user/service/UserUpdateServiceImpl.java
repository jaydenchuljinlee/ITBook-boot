package com.example.ITBook.user.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.ITBook.common.domain.User;
import com.example.ITBook.user.repository.UserRepository;

@Service
public class UserUpdateServiceImpl implements UserUpdateService {

	private static final Logger logger = LoggerFactory.getLogger(UserUpdateServiceImpl.class);
	
	@Autowired
	private UserRepository userRepository;//���� ��ü �������丮
	
	@Autowired
	private PasswordEncoder encoder;// �н����� ��ȣȭ ��ü

	/*
	 * ��й�ȣ üũ
	 * */
	@Override
	public Optional<User> checkIdAndPassword(User user) throws Exception {
		
		Optional<User> stored = userRepository.findByIdentity(user.getIdentity());
		
		if (!stored.isPresent()) throw new UsernameNotFoundException(user.getIdentity());
		
		boolean isTrue = encoder.matches(user.getPassword(), stored.get().getPassword());
		
		return stored;
	}

	/*
	 * ���� Ȱ�� ���°� ��ȭ
	 * */
	@Override
	public boolean deleteUser(User user) throws Exception {

		user.setUpdatedDate(LocalDateTime.now());
		user.setPrincipal("0");
		
		return userRepository.update(user) == 1 ? true : false;
	}

	@Override
	public boolean updateUser(User user) throws Exception {

		String password = encoder.encode(user.getPassword());
		
		user.setPassword(password);
		user.setUpdatedDate(LocalDateTime.now());
		
		return userRepository.update(user) == 1 ? true : false;
		
	}
}
