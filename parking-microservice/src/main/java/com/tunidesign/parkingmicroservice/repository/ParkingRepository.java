package com.tunidesign.parkingmicroservice.repository;

import com.tunidesign.parkingmicroservice.model.Parking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParkingRepository extends JpaRepository<Parking, Long> {
    List<Parking> findAllByGarageId(Long garageId);
}
