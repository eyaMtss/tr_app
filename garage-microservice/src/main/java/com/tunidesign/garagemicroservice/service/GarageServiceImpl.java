package com.tunidesign.garagemicroservice.service;


import com.tunidesign.garagemicroservice.dto.GarageRequestDto;
import com.tunidesign.garagemicroservice.dto.GarageResponseDto;
import com.tunidesign.garagemicroservice.mapper.GarageMapper;
import com.tunidesign.garagemicroservice.mapper.GarageMapperImpl;
import com.tunidesign.garagemicroservice.model.Garage;
import com.tunidesign.garagemicroservice.repository.GarageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GarageServiceImpl implements GarageService{

    @Autowired
    private GarageRepository garageRepository;

    @Autowired
    private final GarageMapper garageMapper = new GarageMapperImpl();
    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    @Override
    public List<GarageResponseDto> getGarages() {
        return garageRepository.findAll().stream().map(garage -> garageMapper.garageToGarageResponseDto(garage)).toList();
    }

    @Override
    public GarageResponseDto getGarageById(Long id) {
        return garageRepository.findById(id).isPresent() ? garageMapper.garageToGarageResponseDto(garageRepository.findById(id).get()) : null;

    }

    @Override
    public GarageResponseDto save(GarageRequestDto garageRequestDTO) {
       return garageMapper.garageToGarageResponseDto(garageRepository.save(garageMapper.garageRequestDtoToGarage(garageRequestDTO)));
    }

    @Override
    public void deleteGarage(Long id) {
        garageRepository.deleteById(id);

    }

    @Override
    public GarageResponseDto update(GarageRequestDto garageRequestDTO) {
        return garageMapper.garageToGarageResponseDto(garageRepository.save(garageMapper.garageRequestDtoToGarage(garageRequestDTO)));
    }

    @Override
    public List<GarageResponseDto> addAll(Long userId, List<GarageRequestDto> garagesRequestDTO) {
        List<Garage> garages = garagesRequestDTO.stream()
                .map(garage -> garageMapper.garageRequestDtoToGarage(garage))
                .toList();
        garages.forEach(garage -> {
            garage.setId(sequenceGeneratorService.generateSequence(Garage.SEQUENCE_NAME));
            garage.setGarageOwner(userId);
        });
        return garageRepository.saveAll(garages).stream()
                .map(garage -> garageMapper.garageToGarageResponseDto(garage))
                .toList();
    }
}
