package com.tunidesign.camionmicroservice.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CamionResponseDTO {
    @Id
    private int id; 
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
