package com.dellux.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.dellux.service.UserInfoUserDetailsService;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SpringSecurityConfig {
	
	//Authentication
	@Bean
	public UserDetailsService userDetailsService() {
		/*
		 * UserDetails admin = User.withUsername("Shailaja1")
		 * .password(encoder.encode("pwd1")) .roles("ADMIN") .build();
		 * 
		 * UserDetails user = User.withUsername("Medha")
		 * .password(encoder.encode("pwd2")) .roles("USER") .build(); return new
		 * InMemoryUserDetailsManager(admin,user);
		 */
		return new UserInfoUserDetailsService();
	}
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		return http.csrf().disable()
		.authorizeHttpRequests()
		.requestMatchers("/products/welcome","/products/new").permitAll()
		.and()
		.authorizeHttpRequests().requestMatchers("/products/**").authenticated()
		.and().formLogin()
		.and().build();
		
	}
	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(userDetailsService());
		authenticationProvider.setPasswordEncoder(passwordEncoder());
		return authenticationProvider;
	}
}
