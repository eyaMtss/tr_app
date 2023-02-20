package com.tunidesign.camionmicroservice.mapper;

import com.tunidesign.camionmicroservice.DTO.CamionRequestDTO;
import com.tunidesign.camionmicroservice.DTO.CamionResponseDTO;
import com.tunidesign.camionmicroservice.model.Camion;

public interface CamionMapper {
    CamionResponseDTO camionToCamionDTO(Camion camion);
    Camion CamionRequestDTOToCamion(CamionRequestDTO camionRequestDTO);
}
