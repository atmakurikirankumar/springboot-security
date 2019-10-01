package com.kiran.explore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableWebSecurity
@EnableJpaRepositories(basePackageClasses = UserRepo.class)
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	// Authorization
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests()
				.antMatchers("/").permitAll()
				.antMatchers("/user").hasAnyRole("USER", "ADMIN")
				.antMatchers("/admin").hasRole("ADMIN")
				.and()
				.formLogin();
	}
	
	// Authentication
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		// inMemoryAuthentication
		
		/*
		 * auth.inMemoryAuthentication()
		 * .withUser("kiran").password("{noop}kiran").roles("USER") .and()
		 * .withUser("preet").password("{noop}preet").roles("ADMIN");
		 */
		
		
		// Mysql Authentication
		auth.userDetailsService(userDetailsService);
	}

}
