package com.tunidesign.camionmicroservice.mapper;

import com.tunidesign.camionmicroservice.DTO.CamionRequestDTO;
import com.tunidesign.camionmicroservice.DTO.CamionResponseDTO;
import com.tunidesign.camionmicroservice.model.Camion;
import org.springframework.stereotype.Component;

@Component
public class CamionMapperImpl implements CamionMapper {
    @Override
    public CamionResponseDTO camionToCamionDTO(Camion camion) {
        return null;
    }

    @Override
    public Camion CamionRequestDTOToCamion(CamionRequestDTO camionRequestDTO) {
        return null;
    }

}
