package com.dellux;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class BootMsProj07EurekaServerForNativeConfigServer {

	public static void main(String[] args) {
		SpringApplication.run(BootMsProj07EurekaServerForNativeConfigServer.class, args);
	}

}
