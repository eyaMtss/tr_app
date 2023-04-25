package com.tunidesign.garagemicroservice.mapper;


import com.tunidesign.garagemicroservice.dto.GarageRequestDto;
import com.tunidesign.garagemicroservice.dto.GarageResponseDto;
import com.tunidesign.garagemicroservice.model.Garage;

public interface GarageMapper {
    GarageResponseDto garageToGarageResponseDto(Garage garage);
    Garage garageRequestDtoToGarage(GarageRequestDto garageRequestDto);
}
