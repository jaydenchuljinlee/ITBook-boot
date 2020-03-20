package com.example.ITBook.common.exception.controllerAdvice;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.ITBook.common.exception.BookIsbnDuplicationException;
import com.example.ITBook.common.exception.BookIsbnNotFoundException;
import com.example.ITBook.common.exception.BookNotFoundException;
import com.example.ITBook.common.exception.DoNotUpdateOrInsertException;
import com.example.ITBook.common.exception.FailedConnectionException;
import com.example.ITBook.common.exception.OveredBookQuantityException;
import com.example.ITBook.common.exception.PamentSizeException;
import com.example.ITBook.common.utils.JsonUtil;

/*
 * 예외 처리 컨트롤러
 * */
@ControllerAdvice
public class CommonExceptionAdvice {
	private static final Logger logger = LoggerFactory.getLogger(CommonExceptionAdvice.class);
	
	private HashMap<String, Object> rtnMap = new HashMap<>();
	
	/*
	 * 일반적인 예외
	 * */
	@ExceptionHandler(Exception.class)
	public String commonException(Exception e) {
	
		logger.info(e.toString());
		
		return "redirect:/common/error";
	}
	
	/*
	 * 책 isbn 중복 예외
	 * */
	@ExceptionHandler(BookIsbnDuplicationException.class)
	public String bookIsbnDuplicationExceptionHandler(BookIsbnDuplicationException e) {
	
		logger.info(e.toString() + "에 대한 isbn 중복");
		
		return "redirect:/common/error";
	}
	
	/*
	 * 책 isbn not found 예외
	 * */
	@ExceptionHandler(BookIsbnNotFoundException.class)
	@ResponseBody
	public String bookIsbnNotFoundExceptionHandler(BookIsbnNotFoundException e) {
	
		String error = e.toString() + "에 대한 책 정보를 찾지 못했습니다.";
		
		rtnMap.put("error", error);
		
		return JsonUtil.HashMapToJson(rtnMap);
	}
	
	/*
	 * 네트워크 연결 예외
	 * */
	@ExceptionHandler(FailedConnectionException.class)
	public String failedConnectionsExceptionHandler(FailedConnectionException e) {
	
		logger.info(e.toString() + "에 대한 연결 에러가 발생하였습니다.");
		
		return "redirect:/common/error";
	}
	
	/*
	 * 데이터베이스 내 isbn not found 예외
	 * */
	@ExceptionHandler(BookNotFoundException.class)
	public String bookNotFoundExceptionHandler(BookNotFoundException e) {
	
		logger.info(e.toString() + "에 대한 책정보를 찾지 못했습니다.");
		
		return "redirect:/common/error";
	}
	
	/*
	 * 결제 사이즈 zero 예외
	 * */
	@ExceptionHandler(PamentSizeException.class)
	public String pamentSizeExceptionHandler(PamentSizeException e) {
	
		String error = e.toString() + "결제를 처리할 데이터를 찾지 못했습니다.";
		
		rtnMap.put("error", error);
		
		return JsonUtil.HashMapToJson(rtnMap);
	}
	
	/*
	 * 결제 수량 초과 예외
	 * */
	@ExceptionHandler(OveredBookQuantityException.class)
	public String overedBookQuantityExceptionnHandler(OveredBookQuantityException e1,OveredBookQuantityException e2) {
	
		logger.info("현재 수량 : "+e1.toString());
		logger.info("구매 수량 : "+e1.toString());
		
		return "redirect:/common/error";
	}
	
	@ExceptionHandler(DoNotUpdateOrInsertException.class)
	public String doNotUpdateOrInsertExceptionHandler() {
	
		String error = "alert('알 수 없는 오류로 데이터가 반영되지 않았습니다.');";
		
		rtnMap.put("error", error);
		
		return JsonUtil.HashMapToJson(rtnMap);
	}
}
