package com.example.ITBook.user.service;

import java.time.LocalDateTime;
import java.util.Optional;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.ITBook.common.domain.User;
import com.example.ITBook.user.repository.UserRepository;

@Slf4j
@Service
public class UserUpdateServiceImpl implements UserUpdateService {
	
	@Autowired
	private UserRepository userRepository;//유저 객체 리파지토리
	
	@Autowired
	private PasswordEncoder encoder;// 패스워드 암호화 객체

	/*
	 * 비밀번호 체크
	 * */
	@Override
	public Optional<User> checkIdAndPassword(User user) throws Exception {

		log.info("UserUpdateServiceImpl.checkIdAndPassword :::");
		
		Optional<User> stored = userRepository.findByIdentity(user.getIdentity());
		
		if (!stored.isPresent()) throw new UsernameNotFoundException(user.getIdentity());
		
		boolean isTrue = encoder.matches(user.getPassword(), stored.get().getPassword());
		
		return stored;
	}

	/*
	 * 유저 활성 상태값 변화
	 * */
	@Override
	public boolean deleteUser(User user) throws Exception {

		log.info("UserUpdateServiceImpl.deleteUser :::");

		user.setUpdatedDate(LocalDateTime.now());
		user.setPrincipal("0");
		
		return userRepository.update(user) == 1 ? true : false;
	}

	@Override
	public boolean updateUser(User user) throws Exception {

		log.info("UserUpdateServiceImpl.updateUser :::");

		String password = encoder.encode(user.getPassword());
		
		user.setPassword(password);
		user.setUpdatedDate(LocalDateTime.now());
		
		return userRepository.update(user) == 1 ? true : false;
		
	}
}
