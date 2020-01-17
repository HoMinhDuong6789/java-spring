package com.trungtamjava.springmvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.trungtamjava.model.Order;
import com.trungtamjava.model.Person;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.trungtamjava.springmvc")
public class HelloWorldConfiguaration {
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/views");
		viewResolver.setSuffix(".jsp");

		return viewResolver;
	}

	@Bean(name = "person", initMethod = "init", destroyMethod = "destroy")
	@Scope(value = "prototype")
	public Person person() {
		Person person = new Person("Trung tam java ", 13);
		return person;
	}

	@Bean(name = "person2")
	public Person person2() {
		Person person = new Person("Trung tam java ", 13);
		return person;
	}

	@Bean
	@Autowired
	@Qualifier("person2")
	public Order order(Person person) {
		return new Order(person);
	}
}
