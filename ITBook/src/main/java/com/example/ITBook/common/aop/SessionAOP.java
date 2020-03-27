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
 * session ���� AOP
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
		
		//�޼��� ����?�� ���� ��
		MethodSignature signature = (MethodSignature) pjp.getSignature();
		
		//�޼����� parameters
		String[] paramNames = signature.getParameterNames();
		
		//�޼����� ���¿��� �޼��带 ����
		Method method = signature.getMethod();
		
		//�� �޼��� �ȿ��� @Session�� ������
		Session sessionAnnotation = method.getAnnotation(Session.class);
		
		//���ǿ� ��� name�� �迭�� �����
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
