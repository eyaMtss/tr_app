package com.tunidesign.shiftmicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@EnableMongoRepositories
public class ShiftMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShiftMicroserviceApplication.class, args);



	}
}
