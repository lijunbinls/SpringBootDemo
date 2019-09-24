package com.springbootDemo.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.springbootDemo.pojo.JSONResult;

//@ControllerAdvice
public class DemoExceptionHandler {
	
	public static final String DEMO_ERROR_VIEW = "error";
	
	/*
	 * //@ExceptionHandler(value = Exception.class) public Object
	 * errorHandler(HttpServletRequest req, HttpServletResponse resp, Exception e)
	 * throws Exception {
	 * 
	 * e.printStackTrace();
	 * 
	 * ModelAndView mav = new ModelAndView(); mav.addObject("exception", e);
	 * mav.addObject("url", req.getRequestURI()); mav.setViewName(DEMO_ERROR_VIEW);
	 * 
	 * return mav; }
	 */
	
	@ExceptionHandler(value = Exception.class)
	public Object errorHandler(HttpServletRequest req, 
			HttpServletResponse resp, Exception e) throws Exception {
		e.printStackTrace();
		
		if(isAjax(req)) {
			return JSONResult.errorException(e.getMessage());
		}else {
		
			ModelAndView mav = new ModelAndView();
			mav.addObject("exception", e);
			mav.addObject("url", req.getRequestURI());
		    mav.setViewName(DEMO_ERROR_VIEW);
		    return mav;
		}
	}
	
	/**
	 * 判断是否为ajax请求
	 * @param req
	 * @return
	 */
	public static boolean isAjax(HttpServletRequest req) {
		return (req.getHeader("X-Requested-With")!=null && "XMLHttpRequest".equals(req.getHeader("X-Requested-With").toString()));
	}
	
	

}
