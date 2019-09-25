package com.springbootDemo.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbootDemo.pojo.JSONResult;
import com.springbootDemo.pojo.User;
import com.springbootDemo.utils.JsonUtils;
import com.springbootDemo.utils.RedisOperator;

@RestController
@RequestMapping("redis")
public class RedisController {
	
	@Autowired
	private StringRedisTemplate strRedis;
	@Autowired
	private RedisOperator redis;
	
	@RequestMapping("test")
	public JSONResult redisTest() {
		
		User user = new User();
		user.setId(1);
		user.setDesc("吱吱咋咋");
		user.setAge(100);
		user.setName("张三");
		user.setBirthday(new Date());
		
		strRedis.opsForValue().set("redis:userTest", JsonUtils.objectToJson(user));
		
		return JSONResult.ok(JsonUtils.jsonToPojo(strRedis.opsForValue().get("redis:userTest"), User.class));
	}
	
	@RequestMapping("jsonlist")
	public JSONResult redisJsonList() {
		
		User user = new User();
		user.setId(1);
		user.setDesc("吱吱咋咋");
		user.setAge(100);
		user.setName("张三");
		user.setBirthday(new Date());
		
		User user1 = new User();
		user1.setId(2);
		user1.setDesc("吱吱咋咋");
		user1.setAge(100);
		user1.setName("李四");
		user1.setBirthday(new Date());
		
		User user2 = new User();
		user2.setId(3);
		user2.setDesc("吱吱咋咋");
		user2.setAge(100);
		user2.setName("赵一");
		user2.setBirthday(new Date());
		
		List<User> userList = new ArrayList<>();
		userList.add(user);
		userList.add(user1);
		userList.add(user2);
		
		redis.set("redis:userList", JsonUtils.objectToJson(userList), 2000);
		List<User> list = JsonUtils.jsonToList(redis.get("redis:userList"), User.class);
		
		return JSONResult.ok(list);
	}

}
