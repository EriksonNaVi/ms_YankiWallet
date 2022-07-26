package com.bootcamp.yankiwallet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MsYankiWalletApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsYankiWalletApplication.class, args);
	}

}
