package com.tunidesign.garagemicroservice.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GarageRequestDTO {
    private int id;
    private String adresse;

    private int capacite;
}
