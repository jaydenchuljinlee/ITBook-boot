package com.example.ITBook.user.service;

import java.time.LocalDateTime;
import java.util.Optional;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.ITBook.common.domain.User;
import com.example.ITBook.common.enums.SocialType;
import com.example.ITBook.common.exception.UserEmailDuplicationException;
import com.example.ITBook.user.repository.UserRepository;

@Slf4j
@Service
public class JoinServiceImpl implements JoinService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	/*
	* ȸ�� ���� ���
	* */
	@Override
	public boolean insertUser(User user) throws Exception{

		log.info("JoinServiceImpl.insertUser :::");

		//ȸ�� ������ �����ϴ��� üũ
		if (userRepository.findByIdentity(user.getIdentity()).isPresent()) {
			
			throw new UserEmailDuplicationException(user.getEmail());
		}

		//��й�ȣ ��ȣȭ
		String password = passwordEncoder.encode(user.getPassword());
		
		user.setSocialType(SocialType.DEFAULT);
		user.setPrincipal("0");
		user.setPassword(password);
		user.setCreatedDate(LocalDateTime.now());
		
		userRepository.save(user);
		
		return userRepository.existsById(user.getUserNo());
		
	}

	/*
	* ���̵� ���� ��ȸ
	* */
	@Override
	public boolean findByEmail(String identity) throws Exception {

		log.info("JoinServiceImpl.findByEmail :::");

		return userRepository.findByIdentity(identity) == null ? false : true;
	}

}
