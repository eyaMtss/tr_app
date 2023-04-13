package com.tunidesign.vehiculemicroservice.mapper;

import com.tunidesign.vehiculemicroservice.DTO.VehiculeRequestDTO;
import com.tunidesign.vehiculemicroservice.DTO.VehiculeResponseDTO;
import com.tunidesign.vehiculemicroservice.model.entity.Vehicule;
import com.tunidesign.vehiculemicroservice.service.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VehiculeMapperImpl implements VehiculeMapper {
    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;
    @Override
    public VehiculeResponseDTO vehiculeToVehiculeDTO(Vehicule vehicule) {
        return VehiculeResponseDTO.builder()
                .id(vehicule.getId())
                .typeImmat(vehicule.getTypeImmat())
                .numImmat(vehicule.getNumImmat())
                .confirmNumImmat(vehicule.getConfirmNumImmat())
                .numChassis(vehicule.getNumChassis())
                .marque(vehicule.getMarque())
                .modele(vehicule.getModele())
                .annee(vehicule.getAnnee())
                .etatVehicule(vehicule.getEtatVehicule())
                .boite(vehicule.getBoite())
                .cylindree(vehicule.getCylindree())
                .carburant(vehicule.getCarburant())
                .typeCarrosserie(vehicule.getTypeCarrosserie())
                .puissance(vehicule.getPuissance())
                .poids(vehicule.getPoids())
                .kilometrage(vehicule.getKilometrage())
                .nbPortes(vehicule.getNbPortes())
                .couleur(vehicule.getCouleur())
                .numContrat(vehicule.getNumContrat())
                .build();
    }

    @Override
    public Vehicule vehiculeRequestDTOToVehicule(VehiculeRequestDTO vehiculeRequestDTO) {
        return Vehicule.builder()
                .id(1L)
                .typeImmat(vehiculeRequestDTO.getTypeImmat())
                .numImmat(vehiculeRequestDTO.getNumImmat())
                .confirmNumImmat(vehiculeRequestDTO.getConfirmNumImmat())
                .numChassis(vehiculeRequestDTO.getNumChassis())
                .marque(vehiculeRequestDTO.getMarque())
                .modele(vehiculeRequestDTO.getModele())
                .annee(vehiculeRequestDTO.getAnnee())
                .etatVehicule(vehiculeRequestDTO.getEtatVehicule())
                .boite(vehiculeRequestDTO.getBoite())
                .cylindree(vehiculeRequestDTO.getCylindree())
                .carburant(vehiculeRequestDTO.getCarburant())
                .typeCarrosserie(vehiculeRequestDTO.getTypeCarrosserie())
                .puissance(vehiculeRequestDTO.getPuissance())
                .poids(vehiculeRequestDTO.getPoids())
                .kilometrage(vehiculeRequestDTO.getKilometrage())
                .nbPortes(vehiculeRequestDTO.getNbPortes())
                .couleur(vehiculeRequestDTO.getCouleur())
                .numContrat(vehiculeRequestDTO.getNumContrat())
                .build();
    }

}
