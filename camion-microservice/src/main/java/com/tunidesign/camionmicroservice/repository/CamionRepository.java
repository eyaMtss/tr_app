package com.tunidesign.camionmicroservice.repository;

import com.tunidesign.camionmicroservice.model.Camion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CamionRepository extends JpaRepository <Camion, Integer>{
    List<Camion> findAll();
    Camion findById(int id);
    Camion save(Camion camion);
    Camion deleteById(int id);
}
