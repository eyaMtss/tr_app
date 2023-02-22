package com.tunidesign.vehiculemicroservice.service;

import com.tunidesign.vehiculemicroservice.DTO.VehiculeRequestDTO;
import com.tunidesign.vehiculemicroservice.DTO.VehiculeResponseDTO;
import com.tunidesign.vehiculemicroservice.mapper.VehiculeMapper;
import com.tunidesign.vehiculemicroservice.repository.VehiculeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehiculeServiceImpl implements VehiculeService {
    @Autowired
    private VehiculeRepository vehiculeRepository;
    private VehiculeMapper vehiculeMapper;

    @Override
    public List<VehiculeResponseDTO> getVehicule() {
        return null;
    }

    @Override
    public VehiculeResponseDTO getVehicule(String id) {
        return null;
    }

    @Override
    public VehiculeResponseDTO save(VehiculeRequestDTO vehiculeRequestDTO) {
        return null;
    }

    @Override
    public void deleteVehicule(String id) {

    }

    @Override
    public VehiculeResponseDTO update(VehiculeRequestDTO vehiculeRequestDTO) {
        return null;
    }

    @Override
    public List<VehiculeResponseDTO> getVehiculeByPostId(String id) {
        return null;
    }
}
