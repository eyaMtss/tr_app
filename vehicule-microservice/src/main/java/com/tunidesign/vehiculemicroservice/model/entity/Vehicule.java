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
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "vehicule")
public class Vehicule {
    @Id
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
