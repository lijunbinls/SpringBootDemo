package com.springbootDemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springbootDemo.pojo.Resource;

@Controller
@RequestMapping("/ftl")
public class FtlUserController {
	
	@Autowired
	private Resource resource;
	
	@RequestMapping("/index")
	public String index(Model map) {
		map.addAttribute("resource", resource);
		return "freemarker/index";
	}
	
	@RequestMapping("/center")
	public String centerindex(Model map) {
		
		return "freemarker/center/center";
	}

}
