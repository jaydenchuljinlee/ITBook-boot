package com.example.ITBook.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.ITBook.common.domain.User;
import com.example.ITBook.user.repository.UserRepository;

@Service
public class UserUpdateServiceImpl implements UserUpdateService {

	@Autowired
	private UserRepository userRepository;//���� ��ü �������丮
	
	@Autowired
	private PasswordEncoder encoder;// �н����� ��ȣȭ ��ü

	@Override
	public boolean checkIdAndPassword(User user) throws Exception {
		
		String password = encoder.encode(user.getPassword());
		
		user.setPassword(password);
		
		boolean isTrue = userRepository.findByEmailAndPassword(user.getEmail(), user.getPassword()).isPresent();
		
		return isTrue;
	}

	/*
	 * ���� Ȱ�� ���°� ��ȭ
	 * */
	@Override
	public void deleteUser(User user) throws Exception {

		userRepository.update(user);
	}

	@Override
	public void updateUser(User user) throws Exception {

		String password = encoder.encode(user.getPassword());
		
		user.setPassword(password);
		
		userRepository.update(user);
		
	}
}
