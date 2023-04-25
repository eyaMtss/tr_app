package com.tunidesign.garagemicroservice.mapper;


import com.tunidesign.garagemicroservice.dto.GarageRequestDto;
import com.tunidesign.garagemicroservice.dto.GarageResponseDto;
import com.tunidesign.garagemicroservice.model.Garage;
import org.springframework.stereotype.Component;


@Component
public class GarageMapperImpl implements GarageMapper{
    @Override
    public GarageResponseDto garageToGarageResponseDto(Garage garage) {
       return  GarageResponseDto.builder()
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
    public Garage garageRequestDtoToGarage(GarageRequestDto garageRequestDto) {
      return  Garage.builder()
              .name(garageRequestDto.getName())
              .email(garageRequestDto.getEmail())
              .phone(garageRequestDto.getPhone())
              .countryCode(garageRequestDto.getCountryCode())
              .dialCode(garageRequestDto.getDialCode())
              .garageType(garageRequestDto.getGarageType())
              .garageOwner(garageRequestDto.getGarageOwner())
              .capacite(garageRequestDto.getCapacite())
              .build();
    }
}
