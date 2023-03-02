package com.tunidesign.parkingmicroservice.mapper;

import com.tunidesign.parkingmicroservice.DTO.ParkingRequestDTO;
import com.tunidesign.parkingmicroservice.DTO.ParkingResponseDTO;
import com.tunidesign.parkingmicroservice.model.Parking;

public interface ParkingMapper {
    Parking parkingResquestDTOToParking(ParkingRequestDTO parkingRequestDTO);
    ParkingResponseDTO parkingToParkingResponseDTO(Parking parking);
}
