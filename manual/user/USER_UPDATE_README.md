회원 정보
-
- 회원 가입, 회원 정보 변경, oauth2 로그인

회원 정보 변경
-
- 회원 정보 변경은 마이페이지 화면에서 회원 정보 변경을 할 수 있게 해 놨으며,
- 정보 변경시 아이디와 비밀번호를 체크하고,(비밀번호 체크시 PasswordEncoer의 match 사용)
- 회원 정보를 삭제할 경우 delete를 하는 것이 아닌, 상태값을 바꿔서 변경사항을 저장하도록 하였습니다.
- 또한,update 쿼리문을 작성하기 위해 JPA repository에 메서드를 작성했습니다.

- 회원 정보 변경 Controller [UserUpdateController.java]
```java
package com.example.ITBook.user.web;

import java.util.Optional;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.ITBook.common.domain.User;
import com.example.ITBook.common.exception.DoNotUpdateOrInsertException;
import com.example.ITBook.user.service.UserUpdateService;

/*
* 유저 정보 변경 컨트롤러
* */
@Slf4j
@Controller
@SessionAttributes("user")
@RequestMapping("/mypage/modify")
public class UserUpdateController {

	@Autowired
	private UserUpdateService userUpdateService;

	/*
	* 정보 변경 메인 페이지
	* */
	@GetMapping()
	public String userUpdateMain() throws Exception {

		log.info("UserUpdateController.userUpdateMain :::");
		
		return "myPage/modifyCheckPassword.myPage-tiles";
	}

	/*
	* 정보 변경시 아이디와 비밀번호 재체크
	* */
	@PostMapping("/check")
	public String userUpdateCheck(@ModelAttribute User user, Model model) throws Exception{

		log.info("UserUpdateController.userUpdateCheck :::");

		Optional<User> relogin = userUpdateService.checkIdAndPassword(user);
		
		if (relogin.isPresent()) {
			
			model.addAttribute("user", relogin.get());
			
			return "myPage/modifyInformation.myPage-tiles";
			
		} else {
			
			return "redirect:/mypage/modify.myPage-tiles?check=false";
		}
	}

	/*
	* 유저 정보 변경
	* */
	@PostMapping("/update")
	public String userUpdate(@ModelAttribute User user, Model model) throws Exception{

		log.info("UserUpdateController.userUpdate :::");

		boolean isSuccess = userUpdateService.updateUser(user);
		
		if (!isSuccess) throw new DoNotUpdateOrInsertException();
		
		return "myPage/modifyInfo.myPage-tiles";
	}

	/*
	* 유저 정보 삭제(회원의 상태를 비활성화)
	* */
	@PostMapping("/delete")
	public String userDelete(@ModelAttribute User user, Model model) throws Exception{

		log.info("UserUpdateController.userDelete :::");

		Optional<User> relogin = userUpdateService.checkIdAndPassword(user);
		
		if (relogin.isPresent()) {
			
			boolean isSuccess = userUpdateService.deleteUser(user);
			
			if (!isSuccess) throw new DoNotUpdateOrInsertException();
			
			return "myPage/modifyInfo";
			
		} else {
			
			return "redirect:myPage/modifyCheckPassword";
		}
	}
}

```
- 회원 정보 변경 Service [UserUpdateServiceImpl.java]
```java
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

```
- 회원 정보 변경 관련 repository[UserRepository.java]
```java
package com.example.ITBook.user.repository;

import com.example.ITBook.common.domain.User;
import com.example.ITBook.common.enums.UserStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    public Optional<User> findByIdentity(String identity);

    List<User> findByUpdatedDateBeforeAndStatusEquals(LocalDateTime localDateTime, UserStatus status);

    @Modifying
    @Transactional
    @Query(value = "UPDATE User SET name = :#{#user.name}"
    		+ ", password = :#{#user.password}"
    		+ ", principal = :#{#user.principal}"
    		+ ", socialType = :#{#user.socialType}"
    		+ ", phone = :#{#user.phone}"
    		+ ", address_1 = :#{#user.address1}"
    		+ ", address_2 = :#{#user.address2}"
    		+ ", address_3 = :#{#user.address3}"
    		+ ", mileage = :#{#user.mileage} WHERE user_no = :#{#user.user_no}",nativeQuery = false)
    int update(@Param("user") User user) throws Exception;
}

```
