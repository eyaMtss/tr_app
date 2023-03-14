package com.tunidesign.vehiculemicroservice.repository;

import com.tunidesign.vehiculemicroservice.model.entity.Vehicule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehiculeRepository extends JpaRepository <Vehicule, Long>{
}
