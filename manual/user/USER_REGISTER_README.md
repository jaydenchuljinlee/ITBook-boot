회원 정보 등록 
-
- 회원 가입, 회원 정보 변경, oauth2 로그인

회원 가입
-

- 회원 가입은 User 정보를 입력 받아 비밀번호 암호화를 통해 이루어 집니다.

- 회원 가입 Contoller  [JoinController.java]

```java
package com.example.ITBook.user.web;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.ITBook.common.annotation.Session;
import com.example.ITBook.common.domain.User;
import com.example.ITBook.common.enums.SocialType;
import com.example.ITBook.common.exception.DoNotUpdateOrInsertException;
import com.example.ITBook.user.service.JoinService;

/*
* 회원가입 컨트롤러
* */
@Slf4j
@Controller
@RequestMapping("/join")
public class JoinController {
	
	@Autowired
	private JoinService joinService;

	/*
	* 회원가입 메인 페이지
	* */
	@GetMapping()
	public String join() {

		log.info("JoinController.join");
		
		return "join/join.join";
	}

	/*
	* 아이디 중복 체크
	* */
	@PostMapping(value="/identityCheck")
	@ResponseBody
	public String identityCheck(@RequestParam(required = false) String identity) throws Exception {

		log.info("JoinController.identityCheck");

		if (!joinService.findByEmail(identity)) return "0";
		else return "1";
	}


	/*
	* 회원가입 성공
	* */
	@PostMapping(value="/joinSuccess")
	public String joinSuccess(@ModelAttribute User user, Model model) throws Exception{

		log.info("JoinController.joinSuccess");

		boolean isSuccess = joinService.insertUser(user);
		
		if (!isSuccess) throw new DoNotUpdateOrInsertException();
		
		return "login/login.tiles2";
	}
}
```

- 회원 가입 Service [JoinServiceImpl.java]
```java
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
	* 회원 정보 등록
	* */
	@Override
	public boolean insertUser(User user) throws Exception{

		log.info("JoinServiceImpl.insertUser :::");

		//회원 정보가 존재하는지 체크
		if (userRepository.findByIdentity(user.getIdentity()).isPresent()) {
			
			throw new UserEmailDuplicationException(user.getEmail());
		}

		//비밀번호 암호화
		String password = passwordEncoder.encode(user.getPassword());
		
		user.setSocialType(SocialType.DEFAULT);
		user.setPrincipal("0");
		user.setPassword(password);
		user.setCreatedDate(LocalDateTime.now());
		
		userRepository.save(user);
		
		return userRepository.existsById(user.getUserNo());
		
	}

	/*
	* 아이디 정보 조회
	* */
	@Override
	public boolean findByEmail(String identity) throws Exception {

		log.info("JoinServiceImpl.findByEmail :::");

		return userRepository.findByIdentity(identity) == null ? false : true;
	}

}
```
