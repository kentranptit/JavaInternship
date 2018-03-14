package com.ominext.springbootinterceptor.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.ominext.springbootinterceptor.interceptor.AdminInterceptor;
import com.ominext.springbootinterceptor.interceptor.LogInterceptor;
import com.ominext.springbootinterceptor.interceptor.OldLoginInterceptor;

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		//LogInterceptor applies for all URLs
		registry.addInterceptor(new LogInterceptor());
		
		//This is the old login href(/admin/oldLogin), it is no longer be used anymore
		//OldLoginInterceptor will be used in order to redirect to the new href
		registry.addInterceptor(new OldLoginInterceptor()).addPathPatterns("/admin/oldLogin");
		
		//This interceptor applies for every URLs that has type " /admin/* "
		//Except for the "/admin/oldLogin" case
		registry.addInterceptor(new AdminInterceptor()).addPathPatterns("/admin/*").excludePathPatterns("/admin/oldLogin");
	}

}
