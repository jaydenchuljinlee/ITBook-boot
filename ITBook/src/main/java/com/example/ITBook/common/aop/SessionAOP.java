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
