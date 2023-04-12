package com.tunidesign.garagemicroservice.repository;


import com.tunidesign.garagemicroservice.model.Garage;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GarageRepository  extends MongoRepository<Garage, Long> {

}
