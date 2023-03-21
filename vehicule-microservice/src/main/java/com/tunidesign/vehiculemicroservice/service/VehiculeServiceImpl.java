package com.tunidesign.vehiculemicroservice.service;

import com.tunidesign.vehiculemicroservice.DTO.VehiculeRequestDTO;
import com.tunidesign.vehiculemicroservice.DTO.VehiculeResponseDTO;
import com.tunidesign.vehiculemicroservice.mapper.VehiculeMapper;
import com.tunidesign.vehiculemicroservice.model.entity.Vehicule;
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
    public List<VehiculeResponseDTO> getVehicles() {
        return vehiculeRepository.findAll().stream().map(vehicule -> vehiculeMapper.vehiculeToVehiculeDTO(vehicule)).toList();
    }

    @Override
    public VehiculeResponseDTO getVehicle(Long id) {
        return vehiculeMapper.vehiculeToVehiculeDTO(vehiculeRepository.findById(id).get());
    }

    @Override
    public VehiculeResponseDTO save(VehiculeRequestDTO vehiculeRequestDTO) {
        return vehiculeMapper.vehiculeToVehiculeDTO(vehiculeRepository.save(vehiculeMapper.vehiculeRequestDTOToVehicule(vehiculeRequestDTO)));
    }

    @Override
    public void deleteVehicle(Long id) {
        vehiculeRepository.deleteById(id);
    }

    @Override
    public VehiculeResponseDTO updateVehicle(VehiculeRequestDTO vehiculeRequestDTO) {
        Vehicule existingVehicule = new Vehicule();
        existingVehicule.setNumImmat(vehiculeRequestDTO.getNumImmat());
        existingVehicule.setPoids(vehiculeRequestDTO.getPoids());
        existingVehicule.setCouleur(vehiculeRequestDTO.getCouleur());
        existingVehicule.setMarque(vehiculeRequestDTO.getMarque());
        existingVehicule.setPuissance(vehiculeRequestDTO.getPuissance());
        existingVehicule.setKilometrage(vehiculeRequestDTO.getKilometrage());
        existingVehicule.setNbPortes(vehiculeRequestDTO.getNbPortes());
        return vehiculeMapper.vehiculeToVehiculeDTO(vehiculeRepository.save(existingVehicule));
    }

    @Override
    public Boolean isExist(Long id) {
        return vehiculeRepository.findById(id).isPresent();
    }
}
