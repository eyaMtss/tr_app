package com.example.agencemicroservice.dto;

import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AgenceResponseDto {
    @Id
    private Long id;
    private int numero ;
    private String name ;
    private int telephone ;
    private String responsable ;
    @Email
    private String email ;
    private String ville  ;
    private String  paye;
    private String gouvernerat ;
    private Long idAssurance;
}