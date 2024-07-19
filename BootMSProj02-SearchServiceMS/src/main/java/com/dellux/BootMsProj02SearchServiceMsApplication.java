package com.dellux;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@EnableDiscoveryClient
public class BootMsProj02SearchServiceMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootMsProj02SearchServiceMsApplication.class, args);
	}

}
