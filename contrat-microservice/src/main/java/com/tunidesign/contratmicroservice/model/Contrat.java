package com.tunidesign.contratmicroservice.model;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Document(collection = "contrat")
public class Contrat {
    @Id
    private Long id ;
    private String numContrat;
    private int type ;
    private float prix ;
    private Long numChassis;
    private Date dateDebut;
    private Date dateFin;
    private Long idAssurance;
    private Long idAgence;
    private Long idClient;
    private Integer cin;

}