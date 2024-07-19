package com.dellux;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class BootMsProj02EurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootMsProj02EurekaServerApplication.class, args);
	}

}
