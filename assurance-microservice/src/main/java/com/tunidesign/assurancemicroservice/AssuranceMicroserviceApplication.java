package com.tunidesign.assurancemicroservice;

import com.tunidesign.assurancemicroservice.model.Assurance;
import com.tunidesign.assurancemicroservice.repository.AssuranceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AssuranceMicroserviceApplication implements CommandLineRunner {
	@Autowired
	private AssuranceRepository assuranceRepository;
	public static void main(String[] args) {
		SpringApplication.run(AssuranceMicroserviceApplication.class, args);
	}

	@Override
	public void run(String... args) {
		Assurance assurance1 = new Assurance(1L, "UPCAR assurances", "R5GJ+3WF, Tunis", "upcar@gmail.com",
				71335183, "TN", "+216", null, null, null, "http://upcar-assurance.com/");
		assurance1 = assuranceRepository.save(assurance1);

		Assurance assurance2 = new Assurance(2L, "AMI Assurances", "R5W7+FRC, Rue des juges, Ariana/Tunisie 2037",
				"ami@gmail.com",
				71234725, "TN", "+216", null, null, null,
				"");
		assurance2 = assuranceRepository.save(assurance2);
	}
}
