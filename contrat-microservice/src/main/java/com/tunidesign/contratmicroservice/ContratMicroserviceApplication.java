package com.tunidesign.contratmicroservice;

import com.tunidesign.contratmicroservice.model.Contrat;
import com.tunidesign.contratmicroservice.repository.ContratRepository;
import com.tunidesign.contratmicroservice.service.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.Date;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@EnableMongoRepositories
public class ContratMicroserviceApplication implements CommandLineRunner {
	@Autowired
	private ContratRepository contratRepository;
	@Autowired
	private SequenceGeneratorService sequenceGeneratorService;
	public static void main(String[] args) {
		SpringApplication.run(ContratMicroserviceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Contrat contrat = contratRepository.save(new Contrat(1L, "contratc1v1", 1, 1500, 12345, null, null, 1L, 1L, 1L, 12345678));
	}
}
