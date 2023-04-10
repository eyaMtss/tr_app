package com.tunidesign.parkingmicroservice.repository;

import com.tunidesign.parkingmicroservice.model.Parking;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParkingRepository extends MongoRepository<Parking, Long> {
    List<Parking> findAllByParkingOwner(Long garageId);
}
