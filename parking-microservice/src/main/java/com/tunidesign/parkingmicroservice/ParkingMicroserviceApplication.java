package com.tunidesign.parkingmicroservice;

import com.tunidesign.parkingmicroservice.model.Parking;
import com.tunidesign.parkingmicroservice.repository.ParkingRepository;
import com.tunidesign.parkingmicroservice.service.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@EnableMongoRepositories
public class ParkingMicroserviceApplication implements CommandLineRunner {
	@Autowired
	private SequenceGeneratorService service;
	@Autowired
	private ParkingRepository parkingRepository;
	public static void main(String[] args) {
		SpringApplication.run(ParkingMicroserviceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//Parking parking = parkingRepository.save(new Parking(1L, "parking 1", 1L, 100, 50, null, null, null, null, null, null));
		//Parking parking2 = parkingRepository.save(new Parking(2L, "parking 2", 1L, 100, 50, null, null, null, null, null, null));
		Parking parking3 = parkingRepository.save(new Parking(1L,"parking 3", 1L, 100, 50, null, null, null, null, null, null));
		Parking parking4 = parkingRepository.save(new Parking(2L,"parking 4", 1L, 100, 50, null, null, null, null, null, null));

	}
}
