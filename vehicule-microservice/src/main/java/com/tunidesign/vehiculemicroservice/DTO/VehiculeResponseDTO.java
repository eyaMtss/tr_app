package com.tunidesign.vehiculemicroservice.DTO;

import com.tunidesign.vehiculemicroservice.model.ennumeration.Couleur;
import com.tunidesign.vehiculemicroservice.model.ennumeration.Marque;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VehiculeResponseDTO {
    private Long id;
    private String typeImmat;
    private String numImmat;
    private String confirmNumImmat;
    private Long numChassis;
    private int poids;
    @Enumerated(EnumType.STRING)
    private Couleur couleur;
    private int kilometrage;
    private int nbPortes;
    private int puissance;
    @Enumerated(EnumType.STRING)
    private Marque marque;
}
