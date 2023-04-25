package com.tunidesign.camionmicroservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CamionResponseDto {
    @Id
    private Long id;
    private String matricule ;

    private String type;

    private int porte;
    private String typeImmat;
    private int serie;
    private int numImmat;
    private int numChassis;
    private String typePoidsLourd;
    private String modele ;
    private int charge ;
    private int poids ;
}
