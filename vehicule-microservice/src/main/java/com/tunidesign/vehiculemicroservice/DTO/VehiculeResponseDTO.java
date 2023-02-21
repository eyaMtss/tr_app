package com.tunidesign.vehiculemicroservice.DTO;

import com.tunidesign.vehiculemicroservice.model.ennumeration.Couleur;
import com.tunidesign.vehiculemicroservice.model.ennumeration.Marque;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehiculeResponseDTO {
    @Id
    private int id ;
    private String numImmat;
    private int poids;
    private Couleur couleur;
    private int kilométrage;
    private int nbPortes;
    private int Puissance;

    private com.tunidesign.vehiculemicroservice.model.ennumeration.Marque Marque;
}
