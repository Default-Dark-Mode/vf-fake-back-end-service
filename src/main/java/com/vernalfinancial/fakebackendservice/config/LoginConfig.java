package com.vernalfinancial.fakebackendservice.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class LoginConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
				.inMemoryAuthentication()
				.withUser("customer1")
				.password("{noop}customer1")
				.roles("customer_role")
				.and()
				.withUser("customer2")
				.password("{noop}customer2")
				.roles("customer_role")
				.and()
				.withUser("admin1")
				.password("{noop}admin1")
				.roles("admin_role")
				.and()
				.withUser("admin2")
				.password("{noop}admin2")
				.roles("admin_role")
				.and()
				.withUser("teller1")
				.password("{noop}teller1")
				.roles("teller_role")
				.and()
				.withUser("teller2")
				.password("{noop}teller2")
				.roles("teller_role");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				.authorizeRequests()
				.anyRequest()
				.permitAll();

		http.csrf().disable();
		http.headers().frameOptions().disable();
//				.httpBasic()
//				.and()
//				.authorizeRequests()
//				.antMatchers("/h2-console**").permitAll()
//				.and()
//				.authorizeRequests()
//				.anyRequest()
//				.hasAnyRole("customer_role", "admin_role", "teller_role")
//				.and()
//				.formLogin();
	}
}
