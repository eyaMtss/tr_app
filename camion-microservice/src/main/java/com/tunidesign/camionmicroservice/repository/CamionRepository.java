package com.tunidesign.camionmicroservice.repository;

import com.tunidesign.camionmicroservice.model.Camion;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CamionRepository extends MongoRepository<Camion, Long> {
}
