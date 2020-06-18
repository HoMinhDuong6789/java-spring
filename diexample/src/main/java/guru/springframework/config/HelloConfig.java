package guru.springframework.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import guru.springframework.services.HelloWorldService;
import guru.springframework.services.HelloWorldServiceEnglishImpl;
import guru.springframework.services.HelloWorldServiceFranceImpl;

@Configuration
public class HelloConfig {

	@Bean
	@Profile("English")
	public HelloWorldService helloWorldServiceEnglish() {
		return new HelloWorldServiceEnglishImpl();
	}
	
	
	@Bean
	@Profile("France")
	public HelloWorldService helloWorldServiceFrance() {
		return new HelloWorldServiceFranceImpl();
	}
}
