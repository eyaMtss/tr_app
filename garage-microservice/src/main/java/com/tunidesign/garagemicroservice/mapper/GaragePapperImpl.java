package com.tunidesign.garagemicroservice.mapper;


import com.tunidesign.garagemicroservice.DTO.GarageRequestDTO;
import com.tunidesign.garagemicroservice.DTO.GarageResponseDTO;
import com.tunidesign.garagemicroservice.model.Garage;
import org.springframework.stereotype.Component;


@Component
public class GaragePapperImpl implements GarageMapper{
    @Override
    public GarageResponseDTO garageToGarageResponseDTO(Garage garage) {
       return  GarageResponseDTO.builder().id(garage.getId())
                .capacite(garage.getCapacite())
                .adresse(garage.getAdresse()).build();

    }

    @Override
    public Garage garageRequestDTOToGarage(GarageRequestDTO garageRequestDTO) {
      return  Garage.builder().id(garageRequestDTO.getId())
               .capacite(garageRequestDTO.getCapacite())
               .adresse(garageRequestDTO.getAdresse()).build();


    }
}
