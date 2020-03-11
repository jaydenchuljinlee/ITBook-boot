package com.example.ITBook.common.aop;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogDvice {
	private static Logger logger = LoggerFactory.getLogger(LogDvice.class);
	
	@Around("execution(* com.example.ITBook.**.*Controller.*(..))"
			+ " or execution(* com.example.ITBook.**.service..*ServiceImpl.*(..))")
	public Object logPring(ProceedingJoinPoint proccedingJoinPoint) throws Throwable {
		
		long start = System.currentTimeMillis();
		
		Object result = proccedingJoinPoint.proceed();
		
		String type = proccedingJoinPoint.getSignature().getDeclaringTypeName();
		String name = "";
		
		if (type.contains("Controller")) {
			name = "Controller : ";
		} else if (type.contains("Service")) {
			name = "Service : ";
		} 
		
		long end = System.currentTimeMillis();
		
		logger.info(name + type + "." + proccedingJoinPoint.getSignature().getName() + "()");
		logger.info("Argument/Parameter : " + Arrays.toString(proccedingJoinPoint.getArgs()));
		logger.info("Running Time " + (end-start));
		logger.info("----------------------------------------------------------------------");
		
		return result;
	}
	
}
