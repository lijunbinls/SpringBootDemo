package com.springbootDemo.service;

import java.util.List;

import com.springbootDemo.pojo.LjUser;

public interface UserService {
	
	//保存用户
	public void saveUser(LjUser ljUser) throws Exception;
	
	//修改用户信息
	public void updateUser(LjUser ljUser);

	//修改用户信息
	public void updateUserOne(LjUser ljUser,String username);
	
	//删除用户信息
	public void deleteUser(int id);
	
	//查询用户信息
	public List<LjUser> selectUserAll();
	
	//分页查询
	public List<LjUser> trendPage(Integer pageSize,Integer pageNo, LjUser ljUser);
	
}
