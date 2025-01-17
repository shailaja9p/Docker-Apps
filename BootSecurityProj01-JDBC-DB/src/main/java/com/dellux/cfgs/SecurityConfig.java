package com.dellux.cfgs;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	public DataSource ds;
	
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(ds).passwordEncoder(new BCryptPasswordEncoder())
		.usersByUsernameQuery("SELECT UNAME,PWD,STATUS FROM USERS WHERE UNAME=?")
		.authoritiesByUsernameQuery("SELECT UNAME,ROLE FROM USER_ROLES WHERE UNAME=?");
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests().antMatchers("/").permitAll()
		.antMatchers("/offers").hasAnyAuthority("CUSTOMER","EMPLOYEE","VISITOR")
		.antMatchers("/balance").hasAnyAuthority("CUSTOMER","EMPLOYEE")
		.antMatchers("/approve").hasAuthority("EMPLOYEE")
		.anyRequest().authenticated()
		
		//.and().httpBasic()
		.and().formLogin()
		
		.and().rememberMe()
		//.and().logout()
		.and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/signout"))
		
		.and().exceptionHandling().accessDeniedPage("/denied");
	}
}
