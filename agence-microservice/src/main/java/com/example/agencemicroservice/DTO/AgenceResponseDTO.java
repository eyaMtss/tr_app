package com.example.agencemicroservice.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AgenceResponseDTO {
    @Id
    private int id;
    private String nom ;
    private int telephone ;
    private String responsable ;
    private String email ;
    private String ville  ;
    private String  paye;
    private String gouvernerat ;
}