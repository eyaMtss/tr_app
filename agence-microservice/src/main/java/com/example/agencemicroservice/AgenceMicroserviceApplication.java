package com.example.agencemicroservice;

import com.example.agencemicroservice.mapper.AgenceMapper;
import com.example.agencemicroservice.mapper.AgenceMapperImpl;
import com.example.agencemicroservice.model.Agence;
import com.example.agencemicroservice.repository.AgenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

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
		Agence agence = agenceRepository.save(new Agence(1L, 1, "agence 1 AMI", 54689587, "agence1", "agence1@ami.com", null, null, null, 2L));
	}

	@Bean
	AgenceMapper agenceMapper(){
		return new AgenceMapperImpl();
	}
}
