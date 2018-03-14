package com.ominext.springbootinterceptor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	@RequestMapping(value = {"/", "/test"})
	public String test(Model model) {
		System.out.println("\n-------- MainController.test --- ");
		System.out.println(" ** You are in Controller ** ");
		return "test";
	}
	
	@Deprecated
	@RequestMapping("/admin/oldLogin")
	public String oldLogin(Model model) {
		//This following line of code will NEVER BE RUN
		return "oldLogin";
	}
	
	@RequestMapping("/admin/login")
	public String login(Model model) {
		System.out.println("\n-------- MainController.login --- ");
		System.out.println(" ** You are in Controller ** ");
		return "login";
	}
}
