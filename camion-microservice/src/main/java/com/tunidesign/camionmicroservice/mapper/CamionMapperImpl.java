package com.tunidesign.camionmicroservice.mapper;

import com.tunidesign.camionmicroservice.dto.CamionRequestDto;
import com.tunidesign.camionmicroservice.dto.CamionResponseDto;
import com.tunidesign.camionmicroservice.model.Camion;
import org.springframework.stereotype.Component;

@Component
public class CamionMapperImpl implements CamionMapper {
    @Override
    public CamionResponseDto camionToCamionDto(Camion camion) {
        return null;
    }

    @Override
    public Camion camionRequestDtoToCamion(CamionRequestDto camionRequestDTO) {
        return null;
    }

}
