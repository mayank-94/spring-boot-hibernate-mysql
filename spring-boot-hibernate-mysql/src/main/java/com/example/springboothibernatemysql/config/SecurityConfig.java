/**
 * 
 */
package com.example.springboothibernatemysql.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * @author Mayank
 *
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.formLogin().disable()
			.csrf().disable()
			.authorizeRequests()
			.antMatchers("/api/hello-world").permitAll()
			.antMatchers("/api/employees/**").hasRole("EMPLOYEE")
			.anyRequest().authenticated()
			.and()
			.httpBasic();
	}
	
	@Bean
	@Override
	protected UserDetailsService userDetailsService() {
		
		UserDetails employee = User
				.builder()
				.username("employee123")
				.password(encoder.encode("password123"))
				.roles("EMPLOYEE")
				.build();
				
		return new InMemoryUserDetailsManager(employee);
	}
	
}
