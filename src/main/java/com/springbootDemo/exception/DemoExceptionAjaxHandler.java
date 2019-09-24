package com.springbootDemo.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.springbootDemo.pojo.JSONResult;

@RestControllerAdvice
public class DemoExceptionAjaxHandler {
	
	@ExceptionHandler(value = Exception.class)
	public Object errorHandler(HttpServletRequest req, Exception e) throws Exception {
		
		e.printStackTrace();
		
		return JSONResult.errorException(e.getMessage());
	}

}
