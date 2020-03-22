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
