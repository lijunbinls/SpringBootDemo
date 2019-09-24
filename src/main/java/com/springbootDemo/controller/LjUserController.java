package com.springbootDemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbootDemo.pojo.JSONResult;
import com.springbootDemo.pojo.LjUser;
import com.springbootDemo.service.UserService;

@RestController
@RequestMapping("/ljUser")
public class LjUserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("saveUser")
	public JSONResult saveUser() throws Exception {
		
		LjUser user = new LjUser();
		user.setName("张飒胖");
		user.setPhone("14695879546");
		user.setSex("1");
		user.setAddress("南山区梧桐街四十六号");
		
		userService.saveUser(user);
		
		return JSONResult.ok("添加成功");
	}
	
	@RequestMapping("updateUser")
	public JSONResult updateUser() {
		
		LjUser user = new LjUser();
		user.setId(2);
		user.setName("张大屌");
		user.setPhone("18476279901");
		user.setSex("000000000000");
		user.setAddress("宝安区自由七队");
		
		userService.updateUser(user);
		
		return JSONResult.ok("修改成功");
	}
	
	@RequestMapping("updateUserOne")
	public JSONResult updateUserOne() {
		
		LjUser user = new LjUser();
		user.setPhone("1****1");
		user.setSex("##******##");
		user.setAddress("龙岗区*****");
		
		userService.updateUserOne(user,"张大屌");
		
		return JSONResult.ok("修改成功");
	}
	
	@RequestMapping("deleteUser")
	public JSONResult deleteUser() {
		
		userService.deleteUser(5);
		
		return JSONResult.ok("删除成功");
	}
	
	@RequestMapping("selectUserAll")
	public JSONResult selectUserAll() {
		
		return JSONResult.ok(userService.selectUserAll());
	}
	
	@RequestMapping("trendPage")
	public JSONResult trendPage() {
		
		LjUser user = new LjUser();
		user.setName("张");
		
		return JSONResult.ok(userService.trendPage(5,1,user));
	}
	
	

}
