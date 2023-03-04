package com.tunidesign.garagemicroservice.repository;


import com.tunidesign.garagemicroservice.model.Garage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GarageRepository  extends JpaRepository<Garage, Integer> {
    List<Garage> findAll();
    Garage findById(int id);
    Garage save(Garage garage);
    Garage deleteById(int id);


}
