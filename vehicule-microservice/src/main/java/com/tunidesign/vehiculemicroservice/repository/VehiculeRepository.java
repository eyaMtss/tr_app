package com.tunidesign.vehiculemicroservice.repository;

import com.tunidesign.vehiculemicroservice.model.entity.Vehicule;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehiculeRepository extends MongoRepository<Vehicule, Long> {
}
