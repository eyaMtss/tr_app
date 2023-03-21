package com.tunidesign.vehiculemicroservice.model.entity;

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
