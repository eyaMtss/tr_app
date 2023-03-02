package com.tunidesign.parkingmicroservice.mapper;

import com.tunidesign.parkingmicroservice.DTO.ParkingRequestDTO;
import com.tunidesign.parkingmicroservice.DTO.ParkingResponseDTO;
import com.tunidesign.parkingmicroservice.model.Parking;

public class ParkingMapperImpl implements ParkingMapper{
    @Override
    public Parking parkingResquestDTOToParking(ParkingRequestDTO parkingRequestDTO) {
        return Parking.builder()
                .name(parkingRequestDTO.getName())
                .capacity(parkingRequestDTO.getCapacity())
                .nbVehicle(parkingRequestDTO.getNbVehicle())
                .country(parkingRequestDTO.getCountry())
                .city(parkingRequestDTO.getCity())
                .governorate(parkingRequestDTO.getGovernorate())
                .zipCode(parkingRequestDTO.getZipCode())
                .latitude(parkingRequestDTO.getLatitude())
                .longitude(parkingRequestDTO.getLongitude())
                .garageId(parkingRequestDTO.getGarageId())
                .build();
    }

    @Override
    public ParkingResponseDTO parkingToParkingResponseDTO(Parking parking) {
        return ParkingResponseDTO.builder()
                .id(parking.getId())
                .name(parking.getName())
                .capacity(parking.getCapacity())
                .nbVehicle(parking.getNbVehicle())
                .country(parking.getCountry())
                .city(parking.getCity())
                .governorate(parking.getGovernorate())
                .zipCode(parking.getZipCode())
                .latitude(parking.getLatitude())
                .longitude(parking.getLongitude())
                .garageId(parking.getGarageId())
                .build();
    }
}
