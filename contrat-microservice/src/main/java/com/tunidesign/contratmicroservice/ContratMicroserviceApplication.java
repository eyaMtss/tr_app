package com.tunidesign.contratmicroservice;

import com.tunidesign.contratmicroservice.model.Contrat;
import com.tunidesign.contratmicroservice.repository.ContratRepository;
import com.tunidesign.contratmicroservice.service.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@EnableMongoRepositories
public class ContratMicroserviceApplication {
	@Autowired
	private SequenceGeneratorService sequenceGeneratorService;
	public static void main(String[] args) {
		SpringApplication.run(ContratMicroserviceApplication.class, args);
	}

	@Bean
	private CommandLineRunner initialData(ContratRepository contratRepository){
		return (args) -> {
			contratRepository.save(new Contrat(1L, "contratc1v1", 1, 1500, 12345, null, null, 1L, 1L, 1L, 12345678));
		};
	}
}
