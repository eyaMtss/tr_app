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
                .kilometrage(vehicule.getKilometrage())
                .poids(vehicule.getPoids())
                .nbPortes(vehicule.getNbPortes())
                .typeImmat(vehicule.getTypeImmat())
                .numImmat(vehicule.getNumImmat())
                .confirmNumImmat(vehicule.getConfirmNumImmat())
                .couleur(vehicule.getCouleur())
                .build();
    }

    @Override
    public Vehicule vehiculeRequestDTOToVehicule(VehiculeRequestDTO vehiculeRequestDTO) {
        return Vehicule.builder()
                .id(vehiculeRequestDTO.getId())
                .marque(vehiculeRequestDTO.getMarque())
                .puissance(vehiculeRequestDTO.getPuissance())
                .kilometrage(vehiculeRequestDTO.getKilometrage())
                .poids(vehiculeRequestDTO.getPoids())
                .nbPortes(vehiculeRequestDTO.getNbPortes())
                .typeImmat(vehiculeRequestDTO.getTypeImmat())
                .numImmat(vehiculeRequestDTO.getNumImmat())
                .confirmNumImmat(vehiculeRequestDTO.getConfirmNumImmat())
                .couleur(vehiculeRequestDTO.getCouleur())
                .build();
    }

}
