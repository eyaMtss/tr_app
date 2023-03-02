package com.tunidesign.parkingmicroservice.controller;

import com.tunidesign.parkingmicroservice.DTO.ParkingRequestDTO;
import com.tunidesign.parkingmicroservice.DTO.ParkingResponseDTO;
import com.tunidesign.parkingmicroservice.exception.ParkingNotFoundException;
import com.tunidesign.parkingmicroservice.service.ParkingServiceImpl;
import jakarta.annotation.security.RolesAllowed;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class ParkingController {
    @Autowired
    private ParkingServiceImpl parkingService;

    static Logger logger = LoggerFactory.getLogger(ParkingController.class);

    @PostMapping(path = "/addParking")
    public ResponseEntity<ParkingResponseDTO> addParking(@Valid @RequestBody ParkingRequestDTO parkingRequestDTO) {
        return new ResponseEntity<>(parkingService.addParking(parkingRequestDTO), HttpStatus.CREATED);
    }

    @PutMapping(path = "/updateParking/{parkingId}")
    public ResponseEntity<ParkingResponseDTO> updateParking(@PathVariable Long parkingId, @Valid @RequestBody ParkingRequestDTO parkingRequestDTO){
        try {
            return new ResponseEntity<>(parkingService.updateParking(parkingId, parkingRequestDTO), HttpStatus.CREATED);
        } catch (Exception e) {
            throw new ParkingNotFoundException("Parking not found");
        }
    }
    @GetMapping("/getAllByOwner/{owner}")
    public ResponseEntity<List<ParkingResponseDTO>> getParkingsByOwner(@PathVariable Long owner) {
        return ResponseEntity.ok().body(parkingService.getParkingsByOwner(owner));
    }
    @GetMapping("/getById/{parkingId}")
    public ResponseEntity<ParkingResponseDTO> getParkingsById(@PathVariable Long parkingId) {
        return ResponseEntity.ok().body(parkingService.getParkingById(parkingId));
    }
    @DeleteMapping("/deleteParking/{parkingId}")
    //@RolesAllowed({"GARAGISTE"})
    public ResponseEntity<Object> deleteParking(@PathVariable Long parkingId) {
        try {
            parkingService.deleteParking(parkingId);
            return ResponseEntity.noContent().build();
        } catch (Exception ex) {
            throw new EntityNotFoundException("User doesn't exist");
        }
    }
}
