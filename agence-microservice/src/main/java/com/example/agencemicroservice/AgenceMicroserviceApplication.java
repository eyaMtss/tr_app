package com.example.agencemicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@EnableMongoRepositories
public class AgenceMicroserviceApplication implements CommandLineRunner {
	@Autowired
	private AgenceRepository agenceRepository;
	public static void main(String[] args) {
		SpringApplication.run(AgenceMicroserviceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Agence agence1 = new Agence(1, 1, "agence 1 AMI", 54689587, "agence1", "agence1@ami.com", null, null, null, 2L);
		agence1 = agenceRepository.save(agence1);
	}
}
