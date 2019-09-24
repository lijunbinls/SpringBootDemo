package com.springbootDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
//扫描mybatis 的mapper包路径
@MapperScan(basePackages = "com.springbootDemo.mapper")
//扫描 所有需要的包，包含一些自用的工具类包 所在的路径
@ComponentScan(basePackages = {"com.springbootDemo","org.n3r.idworker"})
public class FirstSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstSpringBootApplication.class, args);
	}

}
