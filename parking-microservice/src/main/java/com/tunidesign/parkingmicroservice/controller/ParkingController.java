package com.tunidesign.parkingmicroservice.controller;

import com.tunidesign.parkingmicroservice.DTO.ParkingRequestDTO;
import com.tunidesign.parkingmicroservice.DTO.ParkingResponseDTO;
import com.tunidesign.parkingmicroservice.exception.ParkingNotFoundException;
import com.tunidesign.parkingmicroservice.service.ParkingServiceImpl;
import jakarta.annotation.security.RolesAllowed;
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
    //@RolesAllowed({"GARAGISTE"})
    public ResponseEntity<ParkingResponseDTO> addParking(@Valid @RequestBody ParkingRequestDTO parkingRequestDTO) throws Exception {
        try {
            return new ResponseEntity<>(parkingService.addParking(parkingRequestDTO), HttpStatus.CREATED);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @PutMapping(path = "/updateParking/{parkingId}")
    //@RolesAllowed({"GARAGISTE"})
    public ResponseEntity<ParkingResponseDTO> updateParking(@PathVariable Long parkingId, @Valid @RequestBody ParkingRequestDTO parkingRequestDTO) throws Exception {
        try {
            return new ResponseEntity<>(parkingService.updateParking(parkingId, parkingRequestDTO), HttpStatus.CREATED);
        } catch (Exception e) {
            throw new ParkingNotFoundException("Parking not found");
        }
    }
    @GetMapping("/getAllByGarage/{garageId}")
    @RolesAllowed({"GARAGISTE"})
    public ResponseEntity<List<ParkingResponseDTO>> getParkingsByGargage(@PathVariable Long garageId) {
        return ResponseEntity.ok().body(parkingService.getParkingsByGarage(garageId));
    }
    @GetMapping("/getById/{parkingId}")
    @RolesAllowed({"GARAGISTE"})
    public ResponseEntity<ParkingResponseDTO> getParkingsById(@PathVariable Long parkingId) {
        return ResponseEntity.ok().body(parkingService.getParkingById(parkingId));
    }
}
