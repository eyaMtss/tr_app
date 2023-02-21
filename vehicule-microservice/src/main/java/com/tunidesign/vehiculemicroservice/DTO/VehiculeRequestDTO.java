package com.tunidesign.vehiculemicroservice.DTO;

import com.tunidesign.vehiculemicroservice.model.ennumeration.Couleur;
import com.tunidesign.vehiculemicroservice.model.ennumeration.Marque;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehiculeRequestDTO {

        @Id
        private int id;
        private String numImmat;
        private int poids;
        private Couleur couleur;
        private int kilométrage;
        private int nbPortes;
        private int Puissance;

        private Marque Marque;
}
