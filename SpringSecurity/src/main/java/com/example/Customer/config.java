package com.example.Customer;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class config extends WebSecurityConfigurerAdapter{
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
		     .withUser("admin")
		     .password("admin")
		     .roles("admin")
		     .and()
		     .withUser("user")
		     .password("user")
		     .roles("user");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.
		       httpBasic()
		       .and()
		       .authorizeRequests()
		       .antMatchers("/getCustomer").hasAnyRole("user","admin")
		       .antMatchers("/getById").hasAnyRole("user","admin")
		       .antMatchers("/create").hasRole("admin");
		       
		
	}

}
