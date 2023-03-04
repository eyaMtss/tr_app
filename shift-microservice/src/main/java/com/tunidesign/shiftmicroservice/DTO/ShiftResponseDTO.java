package com.tunidesign.shiftmicroservice.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShiftResponseDTO {
    private int id;

    private Date date ;

    private String heureDebut;

    private String heureFin;

    private int idAgence ;
}
