package com.example.ITBook.common.error;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/common/error")
public class CommonErrorController {
	private static final Logger logger = LoggerFactory.getLogger(CommonErrorController.class); 
	
	@RequestMapping(value = "throwable")
	public String throwable(HttpServletRequest request, Model model) {
		
		logger.info("throwable");
		pageErrorLog(request);
		model.addAttribute("msg","예외가 발생했습니다!");
		
		return "common/error";
	}
	
	@RequestMapping(value = "exception")
	public String exception(HttpServletRequest request, Model model) {
		
		logger.info("exception");
		pageErrorLog(request);
		model.addAttribute("msg","예외가 발생했습니다!");
		
		return "common/error";
	}
	
	@RequestMapping(value = "/400")
	public String pageErrorCode400(HttpServletRequest request, Model model) {
		
		logger.info("page error code 400");
		pageErrorLog(request);
		model.addAttribute("msg","예외가 발생했습니다!");
		
		return "common/error";
	}
	
	@RequestMapping(value = "/403")
	public String pageErrorCode403(HttpServletRequest request, Model model) {
		
		logger.info("page error code 403");
		pageErrorLog(request);
		model.addAttribute("msg","예외가 발생했습니다!");
		
		return "common/error";
	}
	
	@RequestMapping(value = "/404")
	public String pageErrorCode404(HttpServletRequest request, Model model) {
		
		logger.info("page error code 404");
		pageErrorLog(request);
		model.addAttribute("msg","예외가 발생했습니다!");
		
		return "common/error";
	}
	
	@RequestMapping(value = "/405")
	public String pageErrorCode405(HttpServletRequest request, Model model) {
		
		logger.info("page error code 405");
		pageErrorLog(request);
		model.addAttribute("msg","예외가 발생했습니다!");
		
		return "common/error";
	}
	
	@RequestMapping(value = "/500")
	public String pageErrorCode500(HttpServletRequest request, Model model) {
		
		logger.info("page error code 500");
		pageErrorLog(request);
		model.addAttribute("msg","예외가 발생했습니다!");
		
		return "common/error";
	}
	
	@RequestMapping(value = "/503")
	public String pageErrorCode503(HttpServletRequest request, Model model) {
		
		logger.info("page error code 503");
		pageErrorLog(request);
		model.addAttribute("msg","예외가 발생했습니다!");
		
		return "common/error";
	}

	private void pageErrorLog(HttpServletRequest request) {
		
		logger.info("status_code : " + request.getAttribute("javax.servlet.error.status_code"));
		logger.info("exception_type : " + request.getAttribute("javax.servlet.error.exception_type"));
		logger.info("message : " + request.getAttribute("javax.servlet.error.message"));
		logger.info("request_uri : " + request.getAttribute("javax.servlet.error.request_uri"));
		logger.info("exception : " + request.getAttribute("javax.servlet.error.exception"));
		logger.info("servlet_name : " + request.getAttribute("javax.servlet.error.servlet_name"));
	}
}
