package com.tunidesign.camionmicroservice.mapper;

import com.tunidesign.camionmicroservice.dto.CamionRequestDto;
import com.tunidesign.camionmicroservice.dto.CamionResponseDto;
import com.tunidesign.camionmicroservice.model.Camion;

public interface CamionMapper {
    CamionResponseDto camionToCamionDto(Camion camion);
    Camion camionRequestDtoToCamion(CamionRequestDto camionRequestDTO);
}
