package com.tunidesign.vehiculemicroservice.mapper;


import com.tunidesign.vehiculemicroservice.DTO.VehiculeRequestDTO;
import com.tunidesign.vehiculemicroservice.DTO.VehiculeResponseDTO;
import com.tunidesign.vehiculemicroservice.model.entity.Vehicule;

public interface VehiculeMapper {
    VehiculeResponseDTO vehiculeToVehiculeDTO(Vehicule vehicule);
    Vehicule vehiculeRequestDTOToVehicule(VehiculeRequestDTO vehiculeRequestDTO);
}
