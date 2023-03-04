package com.tunidesign.garagemicroservice.service;


import com.tunidesign.garagemicroservice.DTO.GarageRequestDTO;
import com.tunidesign.garagemicroservice.DTO.GarageResponseDTO;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface GarageService {
    List<GarageResponseDTO> getGarages();
    GarageResponseDTO getGarageById(int id);
    GarageResponseDTO save(GarageRequestDTO garageRequestDTO);
    void deleteGarage(int id);
    GarageResponseDTO update(GarageRequestDTO garageRequestDTO);
}
