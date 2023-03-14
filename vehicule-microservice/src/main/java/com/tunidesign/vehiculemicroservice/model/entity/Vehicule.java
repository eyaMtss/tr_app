package com.tunidesign.vehiculemicroservice.model;

import com.tunidesign.vehiculemicroservice.model.ennumeration.Couleur;
import com.tunidesign.vehiculemicroservice.model.ennumeration.Marque;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Vehicule {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String numImmat;
    private int poids;
    @Enumerated(EnumType.STRING)
    private Couleur couleur;
    private int kilométrage;
    private int nbPortes;
    private int Puissance;
    @Enumerated(EnumType.STRING)
    private com.tunidesign.vehiculemicroservice.model.ennumeration.Marque Marque;
}
