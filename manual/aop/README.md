# AOP

- aop는 세션 정보를 User 객체에 담아서 사용하기 쉽게 처리하기위해 구현했습니다.


- **@Sesion** 어노테이션 생성 [Session.jva]

```java
package com.example.ITBook.common.annotation;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/*
 * 세션 주입
 * name : 세션을 넣을 변수 이름
 * */

@Retention(RUNTIME)
@Target(METHOD)
public @interface Session {

	//세션의 name들
	String[] name() default {}; 
}

```

- 세션 관련 AOP 정보 생성 [SessionAOP.java]

```java
package com.example.ITBook.common.aop;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.example.ITBook.common.annotation.Session;
import com.example.ITBook.common.domain.User;


/*
 * session 주입 AOP
 * 
 * */
@Slf4j
@Component
@Aspect
public class SessionAOP {

	@Around("@annotation(com.example.ITBook.common.annotation.Session)")
	public Object sessionUser(final ProceedingJoinPoint pjp) throws Throwable {

		log.info("SessionAOP.sessionUser :::");

		HttpServletRequest req = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		
		Object[] args = pjp.getArgs();
		
		//메서드 형태?를 가져 옴
		MethodSignature signature = (MethodSignature) pjp.getSignature();
		
		//메서드의 parameters
		String[] paramNames = signature.getParameterNames();
		
		//메서드의 형태에서 메서드를 뽑음
		Method method = signature.getMethod();
		
		//그 메서드 안에서 @Session을 가져옴
		Session sessionAnnotation = method.getAnnotation(Session.class);
		
		//세션에 담긴 name을 배열에 담아줌
		String[] names = sessionAnnotation.name();
		
		for (int i = 0; i < names.length; i++) {
			for (int j = 0; j < paramNames.length; j++) {
				
				if (names[i].equals(paramNames[j])) {
					args[j] = req.getSession().getAttribute(names[i]);
				}
			}
		}
		
		return pjp.proceed(args);
	}
}

```

- 세션 사용 예시) 장바구니 Controller

```java
@Session(name = "user") // 세션 어노테이션
	@GetMapping()
	public String mybascket(User user// 어노테이션을 통해 AOP가 적용되고, 적용된 AOP의 리턴 값으로 User 파라미터와 매칭
			,Model model) throws Exception {

		log.info("MyBasketWebController.mybascket :::");
		
		List<MyBasket> list = myBasketService.selectByUser(user.getUserNo());
		
		model.addAttribute("myBasketList", list);
		
		return "myPage/myBasket.myPage-tiles";
	}
```
