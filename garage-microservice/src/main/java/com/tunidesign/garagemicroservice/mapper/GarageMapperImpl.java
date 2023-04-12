package com.tunidesign.garagemicroservice.mapper;


import com.tunidesign.garagemicroservice.DTO.GarageRequestDTO;
import com.tunidesign.garagemicroservice.DTO.GarageResponseDTO;
import com.tunidesign.garagemicroservice.model.Garage;
import org.springframework.stereotype.Component;


@Component
public class GarageMapperImpl implements GarageMapper{
    @Override
    public GarageResponseDTO garageToGarageResponseDTO(Garage garage) {
       return  GarageResponseDTO.builder()
               .id(garage.getId())
               .name(garage.getName())
               .email(garage.getEmail())
               .phone(garage.getPhone())
               .countryCode(garage.getCountryCode())
               .dialCode(garage.getDialCode())
               .garageType(garage.getGarageType())
               .garageOwner(garage.getGarageOwner())
               .capacite(garage.getCapacite())
               .build();
    }

    @Override
    public Garage garageRequestDTOToGarage(GarageRequestDTO garageRequestDTO) {
      return  Garage.builder()
              .name(garageRequestDTO.getName())
              .email(garageRequestDTO.getEmail())
              .phone(garageRequestDTO.getPhone())
              .countryCode(garageRequestDTO.getCountryCode())
              .dialCode(garageRequestDTO.getDialCode())
              .garageType(garageRequestDTO.getGarageType())
              .garageOwner(garageRequestDTO.getGarageOwner())
              .capacite(garageRequestDTO.getCapacite())
              .build();
    }
}
