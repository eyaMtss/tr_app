package com.tunidesign.assurancemicroservice;

import com.tunidesign.assurancemicroservice.model.Assurance;
import com.tunidesign.assurancemicroservice.repository.AssuranceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@EnableMongoRepositories
public class AssuranceMicroserviceApplication {
	@Autowired
	private AssuranceRepository assuranceRepository;
	public static void main(String[] args) {
		SpringApplication.run(AssuranceMicroserviceApplication.class, args);
	}

	@Bean
	private CommandLineRunner initialData(AssuranceRepository assuranceRepository){
		return args -> {
			assuranceRepository.save(new Assurance(1L, "UPCAR assurances", "R5GJ+3WF, Tunis", "upcar@gmail.com",
					71335183, "TN", "+216", null, null, null, "http://upcar-assurance.com/"));
			assuranceRepository.save(new Assurance(2L, "AMI Assurances", "R5W7+FRC, Rue des juges, Ariana/Tunisie 2037",
					"ami@gmail.com",
					71234725, "TN", "+216", null, null, null,
					""));
		};
	}
}
