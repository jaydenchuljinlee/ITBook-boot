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
 * ���� ó�� ��Ʈ�ѷ�
 * */
@ControllerAdvice
public class CommonExceptionAdvice {
	private static final Logger logger = LoggerFactory.getLogger(CommonExceptionAdvice.class);
	
	private HashMap<String, Object> rtnMap = new HashMap<>();
	
	/*
	 * �Ϲ����� ����
	 * */
	@ExceptionHandler(Exception.class)
	public String commonException(Exception e) {
	
		logger.info(e.toString());
		
		return "redirect:/common/error";
	}
	
	/*
	 * å isbn �ߺ� ����
	 * */
	@ExceptionHandler(BookIsbnDuplicationException.class)
	public String bookIsbnDuplicationExceptionHandler(BookIsbnDuplicationException e) {
	
		logger.info(e.toString() + "�� ���� isbn �ߺ�");
		
		return "redirect:/common/error";
	}
	
	/*
	 * å isbn not found ����
	 * */
	@ExceptionHandler(BookIsbnNotFoundException.class)
	@ResponseBody
	public String bookIsbnNotFoundExceptionHandler(BookIsbnNotFoundException e) {
	
		String error = e.toString() + "�� ���� å ������ ã�� ���߽��ϴ�.";
		
		rtnMap.put("error", error);
		
		return JsonUtil.HashMapToJson(rtnMap);
	}
	
	/*
	 * ��Ʈ��ũ ���� ����
	 * */
	@ExceptionHandler(FailedConnectionException.class)
	public String failedConnectionsExceptionHandler(FailedConnectionException e) {
	
		logger.info(e.toString() + "�� ���� ���� ������ �߻��Ͽ����ϴ�.");
		
		return "redirect:/common/error";
	}
	
	/*
	 * �����ͺ��̽� �� isbn not found ����
	 * */
	@ExceptionHandler(BookNotFoundException.class)
	public String bookNotFoundExceptionHandler(BookNotFoundException e) {
	
		logger.info(e.toString() + "�� ���� å������ ã�� ���߽��ϴ�.");
		
		return "redirect:/common/error";
	}
	
	/*
	 * ���� ������ zero ����
	 * */
	@ExceptionHandler(PamentSizeException.class)
	public String pamentSizeExceptionHandler(PamentSizeException e) {
	
		String error = e.toString() + "������ ó���� �����͸� ã�� ���߽��ϴ�.";
		
		rtnMap.put("error", error);
		
		return JsonUtil.HashMapToJson(rtnMap);
	}
	
	/*
	 * ���� ���� �ʰ� ����
	 * */
	@ExceptionHandler(OveredBookQuantityException.class)
	public String overedBookQuantityExceptionnHandler(OveredBookQuantityException e1,OveredBookQuantityException e2) {
	
		logger.info("���� ���� : "+e1.toString());
		logger.info("���� ���� : "+e1.toString());
		
		return "redirect:/common/error";
	}
	
	@ExceptionHandler(DoNotUpdateOrInsertException.class)
	public String doNotUpdateOrInsertExceptionHandler() {
	
		String error = "alert('�� �� ���� ������ �����Ͱ� �ݿ����� �ʾҽ��ϴ�.');";
		
		rtnMap.put("error", error);
		
		return JsonUtil.HashMapToJson(rtnMap);
	}
}
