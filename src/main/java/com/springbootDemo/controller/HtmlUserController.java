package com.springbootDemo.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springbootDemo.pojo.User;

@Controller
@RequestMapping("/thymeleaf")
public class HtmlUserController {
	
	@RequestMapping("/index")
	public String index(Model map) {
		map.addAttribute("name", "树先生");
		return "thymeleaf/index";
	}
	
	@RequestMapping("/center")
	public String center(User user) {
		System.out.println(user.getName());
		return "thymeleaf/center/center";
	}
	
	@RequestMapping("/test")
	public String test(Model map) {
		
		User user = new User();
		
		user.setBirthday(new Date());
		user.setName("superadmin");
		user.setId(20);
		user.setAge(22);
		user.setDesc("<span style='color:red'>Hello china</span>");
		
		map.addAttribute("user",user);
		
		return "thymeleaf/test";
	}


}
