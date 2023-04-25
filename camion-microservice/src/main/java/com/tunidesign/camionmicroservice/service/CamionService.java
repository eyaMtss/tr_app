package com.tunidesign.camionmicroservice.service;

import com.tunidesign.camionmicroservice.dto.CamionRequestDto;
import com.tunidesign.camionmicroservice.dto.CamionResponseDto;

import java.util.List;

public interface CamionService {

        List<CamionResponseDto> getCamions();
        CamionResponseDto getCamion(Long id);
        CamionResponseDto save(CamionRequestDto camionRequestDTO);
        void deleteCamion(Long id);
        CamionResponseDto update(CamionRequestDto camionRequestDTO);
}
