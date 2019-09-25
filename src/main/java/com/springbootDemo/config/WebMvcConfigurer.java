package com.springbootDemo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.springbootDemo.controller.interceptor.OneInterceptor;
import com.springbootDemo.controller.interceptor.TwoInterceptor;

@Configuration
public class WebMvcConfigurer extends WebMvcConfigurerAdapter {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		/**
		 * 拦截器按照顺序执行
		 */
		registry.addInterceptor(new OneInterceptor()).addPathPatterns("/user/**").addPathPatterns("/ljUser/**");
		registry.addInterceptor(new TwoInterceptor()).addPathPatterns("/redis/**");
		
		super.addInterceptors(registry);
	}

}
