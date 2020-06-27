package com.trungtamjava.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

import com.trungtamjava.model.Order;
import com.trungtamjava.model.Person;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "com.trungtamjava" })
@PropertySource(value = { "classpath:db.properties" })
@EnableTransactionManagement
public class SpringConfiguaration extends WebMvcConfigurerAdapter {

	@Autowired
	org.springframework.core.env.Environment enviroment;

	@Bean
	public ViewResolver viewResolver() {
		/*
		 * InternalResourceViewResolver viewResolver = new
		 * InternalResourceViewResolver(); viewResolver.setViewClass(JstlView.class);
		 * viewResolver.setPrefix("/WEB-INF/views/"); viewResolver.setSuffix(".jsp");
		 */
		
		TilesViewResolver viewResolver = new TilesViewResolver();
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

	// co the dung cach nay hoac @Compoment phia tren class
	/*
	 * @Bean public UserValidator userValidator() { return new UserValidator(); }
	 */

	@Bean(name = "multipartResolver")
	public MultipartResolver multipartResolver() {
		CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
		commonsMultipartResolver.setMaxUploadSize(-1);
		return commonsMultipartResolver;
	}

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		/*
		 * dataSource.setDriverClassName(enviroment.getProperty("driver"));
		 * dataSource.setUrl(enviroment.getProperty("url"));
		 * dataSource.setUsername(enviroment.getProperty("user"));
		 * dataSource.setPassword(enviroment.getProperty("password"));
		 */
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3308/shop");
		dataSource.setUsername("root");
		dataSource.setPassword("");
		return dataSource;
	}

	@Bean
	public static PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	/*
	 * @Bean public JdbcTemplate jdbcTemplate() { return new
	 * JdbcTemplate(dataSource()); }
	 * 
	 * 
	 * @Bean(name = "transactionManager") public DataSourceTransactionManager
	 * dataSourceTransactionManager() { return new
	 * DataSourceTransactionManager(dataSource()); }
	 */

	@Bean
	public LocalSessionFactoryBean sessionFactoryBean() {
		LocalSessionFactoryBean bean = new LocalSessionFactoryBean();
		bean.setDataSource(dataSource());
		bean.setPackagesToScan("com.trungtamjava.entity");

		// tao properties
		Properties hibernateProperties = new Properties();
		// https://www.tutorialspoint.com/hibernate/hibernate_configuration.htm
		// org.hibernate.dialect.MySQLDialect
		// hibernateProperties.put("hibernate.dialect",
		// hibernateProperties.get("hibernate.dialect"));
		// hibernateProperties.put("hibernate,show_sql",
		// hibernateProperties.get("hibernate,show_sql"));

		hibernateProperties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		hibernateProperties.put("hibernate,show_sql", true);
		bean.setHibernateProperties(hibernateProperties);

		return bean;
	}

	@Bean(name = "transactionManager")
	@Autowired
	public HibernateTransactionManager hibernateTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager();
		hibernateTransactionManager.setSessionFactory(sessionFactory);

		return hibernateTransactionManager;
	}

	@Bean
	public TilesConfigurer titConfigurer() {
		TilesConfigurer configurer = new TilesConfigurer();
		configurer.setDefinitions("classpath:tiles.xml");
		configurer.setCheckRefresh(true);

		return configurer;
	}
	


}
