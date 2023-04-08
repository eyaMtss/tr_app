package com.tunidesign.contratmicroservice.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Contrat
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id ;
    private String numContrat;
    private int type ;
    private float prix ;
    private Long numChassis;
    private Date dateDebut;
    private Date dateFin;

}