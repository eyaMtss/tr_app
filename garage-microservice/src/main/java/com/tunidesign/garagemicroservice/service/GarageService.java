package com.tunidesign.garagemicroservice.service;


import com.tunidesign.garagemicroservice.DTO.GarageRequestDTO;
import com.tunidesign.garagemicroservice.DTO.GarageResponseDTO;

import java.util.List;


public interface GarageService {
    List<GarageResponseDTO> getGarages();
    GarageResponseDTO getGarageById(Long id);
    GarageResponseDTO save(GarageRequestDTO garageRequestDTO);
    void deleteGarage(Long id);
    GarageResponseDTO update(GarageRequestDTO garageRequestDTO);
}
