package com.tunidesign.garagemicroservice.service;


import com.tunidesign.garagemicroservice.dto.GarageRequestDto;
import com.tunidesign.garagemicroservice.dto.GarageResponseDto;

import java.util.List;


public interface GarageService {
    List<GarageResponseDto> getGarages();
    GarageResponseDto getGarageById(Long id);
    GarageResponseDto save(GarageRequestDto garageRequestDTO);
    void deleteGarage(Long id);
    GarageResponseDto update(GarageRequestDto garageRequestDTO);

    List<GarageResponseDto> addAll(Long userId, List<GarageRequestDto> garages);
}
