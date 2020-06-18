package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(DemoApplication.class, args);
		/*
		 * HelloWorldImpl helloWorld= (HelloWorldImpl) ctx.getBean("helloWorld");
		 * helloWorld.sayHello();
		 */
		
		InjectedByConstructorService constructorService = (InjectedByConstructorService) ctx.getBean("injectedByConstructorService");
		constructorService.getMessage();
		
		//cach 2: set
		SetterBasedService setterBasedService= (SetterBasedService) ctx.getBean("setterBasedService");
		setterBasedService.getMessage();
	}

}
