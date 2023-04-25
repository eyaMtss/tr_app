package com.example.agencemicroservice;

import com.example.agencemicroservice.model.Agence;
import com.example.agencemicroservice.repository.AgenceRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@EnableMongoRepositories
public class AgenceMicroserviceApplication {
	public static void main(String[] args) {
		SpringApplication.run(AgenceMicroserviceApplication.class, args);
	}

	@Bean
	public CommandLineRunner initialData(AgenceRepository agenceRepository){
		return args ->
			agenceRepository.save(new Agence(1L, 1, "agence 1 AMI", 54689587, "agence1", "agence1@ami.com", null, null, null, 2L));
	}
}
