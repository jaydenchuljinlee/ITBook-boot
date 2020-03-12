package com.example.ITBook.common.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CommonExceptionAdvice {

private static final Logger logger = LoggerFactory.getLogger(CommonExceptionAdvice.class);
	
	@ExceptionHandler(Exception.class)
	public String commonException(Exception e) {
	
		logger.info(e.toString());
		
		return "redirect:/common/error";
	}
	
	@ExceptionHandler(BookIsbnDuplicationException.class)
	public String bookIsbnDuplicationExceptionHandler(BookIsbnDuplicationException e) {
	
		logger.info(e.toString() + "에 대한 isbn 중복");
		
		return "redirect:/common/error";
	}
	
	@ExceptionHandler(BookIsbnNotFoundException.class)
	public String bookIsbnNotFoundExceptionHandler(BookIsbnNotFoundException e) {
	
		logger.info(e.toString() + "에 대한 책 정보를 찾지 못했습니다.");
		
		return "redirect:/common/error";
	}
	
	@ExceptionHandler(FailedConnectionException.class)
	public String failedConnectionsExceptionHandler(FailedConnectionException e) {
	
		logger.info(e.toString() + "에 대한 연결 에러가 발생하였습니다.");
		
		return "redirect:/common/error";
	}
	
	@ExceptionHandler(BookNotFoundException.class)
	public String bookNotFoundExceptionHandler(BookNotFoundException e) {
	
		logger.info(e.toString() + "에 대한 책정보를 찾지 못했습니다.");
		
		return "redirect:/common/error";
	}
}
