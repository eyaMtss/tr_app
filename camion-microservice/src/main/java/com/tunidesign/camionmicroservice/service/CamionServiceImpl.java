package com.tunidesign.camionmicroservice.service;

import com.tunidesign.camionmicroservice.dto.CamionRequestDto;
import com.tunidesign.camionmicroservice.dto.CamionResponseDto;
import com.tunidesign.camionmicroservice.mapper.CamionMapper;
import com.tunidesign.camionmicroservice.mapper.CamionMapperImpl;
import com.tunidesign.camionmicroservice.model.Camion;
import com.tunidesign.camionmicroservice.repository.CamionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CamionServiceImpl implements CamionService {
    @Autowired
    private CamionRepository camionRepository;
    private CamionMapper camionMapper = new CamionMapperImpl();

    @Override
    public List<CamionResponseDto> getCamions() {
        return camionRepository.findAll().stream().map(camion -> camionMapper.camionToCamionDto(camion)).toList();
    }

    @Override
    public CamionResponseDto getCamion(Long id) {
        if(camionRepository.findById(id).isPresent()){
            return camionMapper.camionToCamionDto(camionRepository.findById(id).get());
        }
        else return null;
    }

    @Override
    public CamionResponseDto save(CamionRequestDto camionRequestDTO) {
        return null;
    }

    @Override
    public void deleteCamion(Long id) {
        camionRepository.deleteById(id);
    }

    @Override
    public CamionResponseDto update(CamionRequestDto camionRequestDto) {
        if(camionRepository.findById(camionRequestDto.getId()).isPresent()){
            Camion existingCamion = camionRepository.findById(camionRequestDto.getId()).get();
            camionRequestDto.setId(existingCamion.getId());
            return camionMapper.camionToCamionDto(camionRepository.save(camionMapper.camionRequestDtoToCamion(camionRequestDto)));
        }
        else return null;
    }

}
