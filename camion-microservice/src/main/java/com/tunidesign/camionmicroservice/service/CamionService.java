package com.tunidesign.camionmicroservice.service;

import com.tunidesign.camionmicroservice.DTO.CamionRequestDTO;
import com.tunidesign.camionmicroservice.DTO.CamionResponseDTO;

import java.util.List;

public interface CamionService {

        List<CamionResponseDTO> getCamion();
        CamionResponseDTO getCamion(String id);
        CamionResponseDTO save(CamionRequestDTO camionRequestDTO);
        void deleteCamion( String id);
        CamionResponseDTO update(CamionRequestDTO camionRequestDTO);
        List <CamionResponseDTO> getCamionByPostId(String id);
}
