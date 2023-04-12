package com.example.agencemicroservice.model;

import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "agence")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Agence {
    @Transient
    public static final String SEQUENCE_NAME = "agence_sequence";
    @Id
    private Long id;
    private int numero ;
    private String name;
    private int telephone ;
    private String responsable ;
    @Email
    private String email ;
    private String ville  ;
    private String  paye;
    private String gouvernerat ;
    private Long idAssurance;

}
