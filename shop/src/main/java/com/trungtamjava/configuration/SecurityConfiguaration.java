package com.trungtamjava.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguaration extends WebSecurityConfigurerAdapter {

	@Autowired
	DataSource dataSource;

	/*
	 * @Autowired public void configAuthentication(AuthenticationManagerBuilder
	 * auth) throws Exception { auth.jdbcAuthentication().dataSource(dataSource)
	 * .usersByUsernameQuery("SELECT user, password, enabled FROM user WHERE username = ?"
	 * )
	 * .authoritiesByUsernameQuery("SELECT username, role FROM user WHERE username = ?"
	 * ); }
	 */

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource)
				.usersByUsernameQuery("SELECT username, password, enabled FROM user WHERE username = ?")
				.authoritiesByUsernameQuery("SELECT username , role FROM user WHERE username = ?");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.csrf().disable().authorizeRequests().antMatchers("/admin/**").hasRole("admin")
		.and().authorizeRequests().antMatchers("/user/**").hasRole("user").anyRequest()
		.permitAll().and().formLogin().loginPage("/dang-nhap").loginProcessingUrl("/login")
		.usernameParameter("username").passwordParameter("password")
		.defaultSuccessUrl("/list-product").failureUrl("/dang-nhap?error=failed")
		.and().exceptionHandling().accessDeniedPage("/dang-nhap?error= deny");

		/*
		 * http.csrf().disable().authorizeRequests().antMatchers("/admin/**").hasAnyRole
		 * ("admin").and().formLogin()
		 * .loginPage("/login").failureUrl("/login?error").usernameParameter("username")
		 * .passwordParameter("password").and().logout().logoutSuccessUrl(
		 * "/login?logout").and() .exceptionHandling().accessDeniedPage("/403");
		 */
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/static/**");
	}
}