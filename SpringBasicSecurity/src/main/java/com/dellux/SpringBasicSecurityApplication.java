package com.dellux;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
public class SpringBasicSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBasicSecurityApplication.class, args);
	}

}
