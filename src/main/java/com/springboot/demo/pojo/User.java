package com.springboot.demo.pojo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class User {
	
	/**
	 * @JsonIgnore 不显示
	 * @JsonInclude(Include.NON_NULL) 为空时不显示
	 * @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss a",locale="zh",timezone = "GMT+8") 转换成时间模式
	 */
	
	@JsonIgnore
	private int id;
	
	@JsonInclude(Include.NON_NULL)
	private String name;
	private int age;
	
	@JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss a",locale="zh",timezone = "GMT+8")
	private Date birthday;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	
	
	
	

}
