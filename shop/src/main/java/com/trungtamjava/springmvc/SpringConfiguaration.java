package com.trungtamjava.springmvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.trungtamjava.model.Order;
import com.trungtamjava.model.Person;
import com.trungtamjava.model.User;
import com.trungtamjava.validator.UserValidator;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.trungtamjava.springmvc")
public class SpringConfiguaration extends WebMvcConfigurerAdapter {

	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

	@Bean(name = "person", initMethod = "init", destroyMethod = "destroy")
	@Scope(value = "prototype")
	public Person person() {
		Person person = new Person("J4Team", 4);
		return person;
	}

	@Bean(name = "person2", initMethod = "init", destroyMethod = "destroy")
	public Person person2() {
		Person person = new Person("J4Team", 4);
		return person;
	}

	@Bean
	@Autowired
	@Qualifier("person2") // neu co hai bean cung kieu du lieu, thi bat buoc phai co ten khac nhau de bean
							// biet duoc
	public Order order(Person person) {
		Order order = new Order(person);
		return order;
	}

	/*
	 * @Bean
	 * 
	 * @Autowired public User user() { User user = new User("j4Team"); return user;
	 * }
	 */

	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource bundleMessageSource = new ReloadableResourceBundleMessageSource();
		bundleMessageSource.setBasename("classpath:messages");
		bundleMessageSource.setDefaultEncoding("utf-8");
		return bundleMessageSource;
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/static/**").addResourceLocations("/resouces/");

	}
	
	@Bean
	public UserValidator userValidator() {
		return new UserValidator();
	}
}
