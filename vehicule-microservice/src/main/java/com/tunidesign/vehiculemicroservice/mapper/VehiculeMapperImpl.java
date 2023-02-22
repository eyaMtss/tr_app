package com.tunidesign.vehiculemicroservice.mapper;

import com.tunidesign.vehiculemicroservice.DTO.VehiculeRequestDTO;
import com.tunidesign.vehiculemicroservice.DTO.VehiculeResponseDTO;
import com.tunidesign.vehiculemicroservice.model.entity.Vehicule;
import org.springframework.stereotype.Component;

@Component
public class VehiculeMapperImpl implements VehiculeMapper {
    @Override
    public VehiculeResponseDTO vehiculeToVehiculeDTO(Vehicule vehicule) {
        return null;
    }

    @Override
    public Vehicule vehiculeRequestDTOToVehicule(VehiculeRequestDTO vehiculeRequestDTO) {
        return null;
    }

}
