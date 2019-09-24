package com.springbootDemo.mapper;


import java.util.List;

import com.springbootDemo.pojo.LjUser;
import com.springbootDemo.utils.MyMapper;

public interface LjUserMapper extends MyMapper<LjUser> {
	
	List<LjUser> selectAlls(String name);

	
}