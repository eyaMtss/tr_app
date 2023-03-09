package com.tunidesign.shiftmicroservice.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.util.Date;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class ShiftRequestDTO {
    private int id;

    private Date date ;

    private String heureDebut;

    private String heureFin;

    private int idAgence ;
}