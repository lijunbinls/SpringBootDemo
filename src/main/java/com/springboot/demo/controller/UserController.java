package com.springboot.demo.controller;

import java.util.Date;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.demo.pojo.JSONResult;
import com.springboot.demo.pojo.Resource;
import com.springboot.demo.pojo.User;

/**
 * 
 * @author 李先生
 * @RestController = @ResponseBody + @Controller
 *
 */
@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private Resource resource;
	
	@RequestMapping("/getUserInfo")
	public JSONResult getUserInfo() {
		
		User user = new User();
		user.setAge(100);
		user.setName("张三");
		user.setBirthday(new Date());
		user.setId(10);
		
		return JSONResult.ok(user);
	}
	
	@RequestMapping("/getResource")
	public JSONResult getResource() {
		
		Resource bean = new Resource();
		BeanUtils.copyProperties(resource, bean);

		return JSONResult.ok(bean);
	}
	
	

}
