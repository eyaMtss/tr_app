package com.tunidesign.garagemicroservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GarageResponseDto {
    private Long id;
    private String name;
    private String email;
    private Integer phone;
    private String countryCode;
    private String dialCode;
    private String adresse;
    private String garageType;
    private Long garageOwner;
    private int capacite;
}
