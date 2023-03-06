package com.tunidesign.garagemicroservice.mapper;


import com.tunidesign.garagemicroservice.DTO.GarageRequestDTO;
import com.tunidesign.garagemicroservice.DTO.GarageResponseDTO;
import com.tunidesign.garagemicroservice.model.Garage;

public interface GarageMapper {
    GarageResponseDTO garageToGarageResponseDTO(Garage garage);
    Garage garageRequestDTOToGarage(GarageRequestDTO garageRequestDTO);
}
