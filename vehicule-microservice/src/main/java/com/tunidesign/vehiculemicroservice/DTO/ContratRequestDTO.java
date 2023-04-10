package com.tunidesign.vehiculemicroservice.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ContratRequestDTO {
    private String numContrat;
    private Long numChassis;
    private Date dateDebut;
    private Date dateFin;
    private Long idAssurance;
    private Long idAgence;
    private Integer cin;
}
