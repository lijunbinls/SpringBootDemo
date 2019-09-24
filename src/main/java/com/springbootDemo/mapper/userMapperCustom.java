package com.springbootDemo.mapper;

import java.util.List;

import com.springbootDemo.pojo.LjUser;

public interface userMapperCustom {
	
	List<LjUser> selectAlls(String name);
	
	

}
