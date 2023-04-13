package com.tunidesign.vehiculemicroservice.model.entity;

import com.tunidesign.vehiculemicroservice.model.ennumeration.Couleur;
import com.tunidesign.vehiculemicroservice.model.ennumeration.Marque;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import org.springframework.data.annotation.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "vehicule")
public class Vehicule {
    @Transient
    public static final String SEQUENCE_NAME = "vehicule_sequence";
    @Id
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
