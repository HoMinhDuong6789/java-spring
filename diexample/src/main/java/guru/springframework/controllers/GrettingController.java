package guru.springframework.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import guru.springframework.services.HelloWorldService;
import guru.springframework.services.HelloWorldServiceEnglishImpl;

@Controller
public class GrettingController{

	private HelloWorldService helloWorkService;
	
	@Autowired
	public void setHelloWorkService(HelloWorldService helloWorkService) {
		this.helloWorkService = helloWorkService;
	}
	
	public String sayHello() {
		String gretting = helloWorkService.getGreeting();
		System.out.println(gretting);
		return gretting;
	}
	
}
