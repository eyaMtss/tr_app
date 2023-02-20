package com.tunidesign.camionmicroservice.service;

import com.tunidesign.camionmicroservice.DTO.CamionRequestDTO;
import com.tunidesign.camionmicroservice.DTO.CamionResponseDTO;
import com.tunidesign.camionmicroservice.mapper.CamionMapper;
import com.tunidesign.camionmicroservice.repository.CamionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CamionServiceImpl implements CamionService {
    @Autowired
    private CamionRepository camionRepository;
    private CamionMapper camionMapper;

    @Override
    public List<CamionResponseDTO> getCamion() {
        return null;
    }

    @Override
    public CamionResponseDTO getCamion(String id) {
        return null;
    }

    @Override
    public CamionResponseDTO save(CamionRequestDTO camionRequestDTO) {
        return null;
    }

    @Override
    public void deleteCamion(String id) {

    }

    @Override
    public CamionResponseDTO update(CamionRequestDTO camionRequestDTO) {
        return null;
    }

    @Override
    public List<CamionResponseDTO> getCamionByPostId(String id) {
        return null;
    }
}
