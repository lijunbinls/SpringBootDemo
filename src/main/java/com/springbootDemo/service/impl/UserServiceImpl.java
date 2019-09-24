package com.springbootDemo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.mysql.jdbc.StringUtils;
import com.springbootDemo.mapper.LjUserMapper;
import com.springbootDemo.mapper.userMapperCustom;
import com.springbootDemo.pojo.LjUser;
import com.springbootDemo.service.UserService;

import tk.mybatis.mapper.entity.Example;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private LjUserMapper userMapper;
	@Autowired
	private userMapperCustom userCustom;
	
	//保存用户
	@Transactional(propagation = Propagation.REQUIRED)
	public void saveUser(LjUser ljUser) throws Exception {
		userMapper.insertSelective(ljUser);
	}
	
	//修改用户信息
	@Transactional(propagation = Propagation.REQUIRED)
	public void updateUser(LjUser ljUser) {
		userMapper.updateByPrimaryKeySelective(ljUser);
	}
	
	//修改用户信息
	@Transactional(propagation = Propagation.REQUIRED)
	public void updateUserOne(LjUser ljUser,String username) {
		
		Example example = new Example(LjUser.class);
		example.createCriteria().andEqualTo("name", username);
		
		userMapper.updateByExampleSelective(ljUser, example);
	}
	
	//删除用户信息
	@Transactional(propagation = Propagation.REQUIRED)
	public void deleteUser(int id) {
		userMapper.deleteByPrimaryKey(id);
	}
	
	//查询用户信息
	@Transactional(propagation = Propagation.SUPPORTS)
	public List<LjUser> selectUserAll(){
		return userMapper.selectAlls("123");
	}
	
	//分页查询
	@Transactional(propagation = Propagation.SUPPORTS)
	public List<LjUser> trendPage(Integer pageSize,Integer pageNo, LjUser ljUser){
		
		//查询的页码及展示的数量
		PageHelper.startPage(pageNo,pageSize);
		
		Example example = new Example(LjUser.class);
		Example.Criteria criteria = example.createCriteria();
		
		//查询条件
		if(!StringUtils.isEmptyOrWhitespaceOnly(ljUser.getName())) {
			criteria.andLike("name", "%"+ljUser.getName()+"%");
		}
		
		//倒序
		example.orderBy("id").desc();
		
		return userMapper.selectByExample(example);
	}

}
