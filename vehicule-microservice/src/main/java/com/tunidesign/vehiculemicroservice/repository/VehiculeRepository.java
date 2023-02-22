package com.tunidesign.vehiculemicroservice.repository;

import com.tunidesign.vehiculemicroservice.model.entity.Vehicule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehiculeRepository extends JpaRepository <Vehicule, Integer>{
    List<Vehicule> findAll();
    Vehicule findById(int id);
    Vehicule save(Vehicule vehicule);
    Vehicule deleteById(int id);
}
