package com.ominext.helloworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class HelloWorldApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(HelloWorldApplication.class, args);
		HelloBean helloBean = context.getBean(HelloBean.class);
		System.out.println("PROJECT SAID: " + "'" + helloBean.sayHello() + "'");
	}
}
