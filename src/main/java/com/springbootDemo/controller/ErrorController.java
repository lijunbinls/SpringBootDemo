package com.springbootDemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springbootDemo.pojo.JSONResult;
import com.springbootDemo.pojo.LjUser;
import com.springbootDemo.service.UserService;

@Controller
@RequestMapping("error")
public class ErrorController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("errorHtml")
	public String errorHtml() {
		return "thymeleaf/ajaxError";
	}
	
	
	@RequestMapping(value="errorValue")
	@ResponseBody
	public JSONResult errorText() throws Exception {
		
		LjUser user = new LjUser();
		user.setName("张飒胖");
		user.setPhone("14695879546");
		user.setSex("1");
		user.setAddress("南山区梧桐街四十六号");
		
		userService.saveUser(user);
		
		int a = 1/0;
		return JSONResult.ok();
	}

}
