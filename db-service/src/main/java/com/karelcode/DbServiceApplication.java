package com.karelcode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@EnableJpaRepositories(basePackages = "com.karelcode.repo")
@EnableEurekaClient
@SpringBootApplication
public class DbServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DbServiceApplication.class, args);
	}

}
