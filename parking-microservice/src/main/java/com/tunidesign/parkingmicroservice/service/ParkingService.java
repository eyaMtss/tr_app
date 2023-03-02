package com.tunidesign.parkingmicroservice.service;

import com.tunidesign.parkingmicroservice.DTO.ParkingRequestDTO;
import com.tunidesign.parkingmicroservice.DTO.ParkingResponseDTO;
import com.tunidesign.parkingmicroservice.model.Parking;

import java.util.List;

public interface ParkingService {
    public ParkingResponseDTO addParking(ParkingRequestDTO parkingRequestDTO);
    public ParkingResponseDTO updateParking(Long parkingId, ParkingRequestDTO parkingRequestDTO);
    public List<ParkingResponseDTO> getParkings();
    public List<ParkingResponseDTO> getParkingsByGarage(Long garageId);
    public ParkingResponseDTO getParkingById(Long parkingId);
    public void deleteParking(Long parkingId);
    public Boolean isExist(Long parkingId);
}
