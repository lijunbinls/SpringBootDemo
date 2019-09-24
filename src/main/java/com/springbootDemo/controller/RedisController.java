package com.springbootDemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbootDemo.pojo.JSONResult;

@RestController
@RequestMapping("redis")
public class RedisController {
	
	@Autowired
	private StringRedisTemplate strRedis;
	
	@RequestMapping("test")
	public JSONResult redisTest() {
		
		strRedis.opsForValue().set("redis-loginTest", "second commit(第二次提交)");
		
		return JSONResult.ok(strRedis.opsForValue().get("redis-loginTest"));
	}

}
