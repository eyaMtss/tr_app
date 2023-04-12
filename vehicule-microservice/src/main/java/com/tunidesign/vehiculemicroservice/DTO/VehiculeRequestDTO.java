package com.tunidesign.vehiculemicroservice.DTO;

import com.tunidesign.vehiculemicroservice.model.ennumeration.Couleur;
import com.tunidesign.vehiculemicroservice.model.ennumeration.Marque;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VehiculeRequestDTO {
        private Long id;
        private String typeImmat;
        private String numImmat;
        private String confirmNumImmat;
        private Long numChassis;
        //@Enumerated(EnumType.STRING)
        private String marque;
        private String modele;
        private String annee;
        private String etatVehicule;
        private String boite;
        private String cylindree;
        private String carburant;
        private String typeCarrosserie;
        private int puissance;
        private int poids;
        private int kilometrage;
        private int nbPortes;
        //@Enumerated(EnumType.STRING)
        private String couleur;
        private String numContrat;
}
