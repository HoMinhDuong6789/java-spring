package guru.springframework.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import guru.springframework.services.HelloWorldFactory;
import guru.springframework.services.HelloWorldService;
import guru.springframework.services.HelloWorldServiceEnglishImpl;
import guru.springframework.services.HelloWorldServiceFranceImpl;

@Configuration
public class HelloConfig {

	
	@Bean
	public HelloWorldFactory helloWorldFactory() {
		return new HelloWorldFactory();
	}
	
	@Bean
	@Profile("English")
	public HelloWorldService helloWorldServiceEnglish(HelloWorldFactory factory) {
		//return new HelloWorldServiceEnglishImpl();
		return factory.createHelloWorldService("en");
	}
	
	
	@Bean
	@Profile("France")
	public HelloWorldService helloWorldServiceFrance(HelloWorldFactory factory) {
		return factory.createHelloWorldService("fr");
	}
}
