package com.tunidesign.garagemicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@EnableMongoRepositories(basePackages = "com.tunidesign.garagemicroservice.repository")
public class GarageMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GarageMicroserviceApplication.class, args);
	}

}
