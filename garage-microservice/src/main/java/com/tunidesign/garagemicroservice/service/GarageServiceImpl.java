package com.tunidesign.garagemicroservice.service;


import com.tunidesign.garagemicroservice.DTO.GarageRequestDTO;
import com.tunidesign.garagemicroservice.DTO.GarageResponseDTO;
import com.tunidesign.garagemicroservice.mapper.GarageMapper;
import com.tunidesign.garagemicroservice.repository.GarageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GarageServiceImpl implements GarageService{

    @Autowired
    private GarageRepository garageRepository;

    @Autowired
    private GarageMapper garageMapper;
    @Override
    public List<GarageResponseDTO> getGarages() {
        return garageRepository.findAll().stream().map(garage -> garageMapper.garageToGarageResponseDTO(garage)).toList();
    }

    @Override
    public GarageResponseDTO getGarageById(int id) {
        return garageMapper.garageToGarageResponseDTO(garageRepository.findById(id));
    }

    @Override
    public GarageResponseDTO save(GarageRequestDTO garageRequestDTO) {
       return garageMapper.garageToGarageResponseDTO(garageRepository.save(garageMapper.garageRequestDTOToGarage(garageRequestDTO)));
    }

    @Override
    public void deleteGarage(int id) {
        garageRepository.deleteById(id);

    }

    @Override
    public GarageResponseDTO update(GarageRequestDTO garageRequestDTO) {
        return garageMapper.garageToGarageResponseDTO(garageRepository.save(garageMapper.garageRequestDTOToGarage(garageRequestDTO)));
    }
}
