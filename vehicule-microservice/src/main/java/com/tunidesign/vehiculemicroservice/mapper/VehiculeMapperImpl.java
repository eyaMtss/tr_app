package com.tunidesign.vehiculemicroservice.mapper;

import com.tunidesign.vehiculemicroservice.DTO.VehiculeRequestDTO;
import com.tunidesign.vehiculemicroservice.DTO.VehiculeResponseDTO;
import com.tunidesign.vehiculemicroservice.model.entity.Vehicule;
import org.springframework.stereotype.Component;

@Component
public class VehiculeMapperImpl implements VehiculeMapper {
    @Override
    public VehiculeResponseDTO vehiculeToVehiculeDTO(Vehicule vehicule) {
        return VehiculeResponseDTO.builder()
                .id(vehicule.getId())
                .marque(vehicule.getMarque())
                .puissance(vehicule.getPuissance())
                .kilométrage(vehicule.getKilométrage())
                .poids(vehicule.getPoids())
                .nbPortes(vehicule.getNbPortes())
                .numImmat(vehicule.getNumImmat())
                .couleur(vehicule.getCouleur())
                .build();
    }

    @Override
    public Vehicule vehiculeRequestDTOToVehicule(VehiculeRequestDTO vehiculeRequestDTO) {
        return Vehicule.builder()
                .id(vehiculeRequestDTO.getId())
                .marque(vehiculeRequestDTO.getMarque())
                .puissance(vehiculeRequestDTO.getPuissance())
                .kilométrage(vehiculeRequestDTO.getKilométrage())
                .poids(vehiculeRequestDTO.getPoids())
                .nbPortes(vehiculeRequestDTO.getNbPortes())
                .numImmat(vehiculeRequestDTO.getNumImmat())
                .couleur(vehiculeRequestDTO.getCouleur())
                .build();
    }

}
