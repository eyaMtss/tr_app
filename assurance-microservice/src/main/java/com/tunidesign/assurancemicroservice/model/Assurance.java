package com.tunidesign.assurancemicroservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Assurance {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    private String nom ;
    private String logo ;
    private String adresse ;
    private String listeAgences ;

}
