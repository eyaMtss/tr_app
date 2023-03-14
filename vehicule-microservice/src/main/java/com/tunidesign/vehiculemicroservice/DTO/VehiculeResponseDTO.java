package com.tunidesign.vehiculemicroservice.DTO;

import com.tunidesign.vehiculemicroservice.model.ennumeration.Couleur;
import com.tunidesign.vehiculemicroservice.model.ennumeration.Marque;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VehiculeResponseDTO {
    private Long id;
    private String numImmat;
    private int poids;
    @Enumerated(EnumType.STRING)
    private Couleur couleur;
    private int kilométrage;
    private int nbPortes;
    private int puissance;
    @Enumerated(EnumType.STRING)
    private Marque marque;
}
