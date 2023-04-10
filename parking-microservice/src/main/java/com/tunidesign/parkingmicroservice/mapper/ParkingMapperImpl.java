package com.tunidesign.parkingmicroservice.mapper;

import com.tunidesign.parkingmicroservice.DTO.ParkingRequestDTO;
import com.tunidesign.parkingmicroservice.DTO.ParkingResponseDTO;
import com.tunidesign.parkingmicroservice.model.Parking;
import com.tunidesign.parkingmicroservice.service.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;

public class ParkingMapperImpl implements ParkingMapper{
    @Autowired
    private SequenceGeneratorService service;
    @Override
    public Parking parkingResquestDTOToParking(ParkingRequestDTO parkingRequestDTO) {
        return Parking.builder()
                //.parkingOwner((long) SequenceGeneratorService.generateSequence(Parking.SEQUENCE_NAME))
                .name(parkingRequestDTO.getName())
                .capacity(parkingRequestDTO.getCapacity())
                .nbVehicle(parkingRequestDTO.getNbVehicle())
                .country(parkingRequestDTO.getCountry())
                .city(parkingRequestDTO.getCity())
                .governorate(parkingRequestDTO.getGovernorate())
                .zipCode(parkingRequestDTO.getZipCode())
                .latitude(parkingRequestDTO.getLatitude())
                .longitude(parkingRequestDTO.getLongitude())
                .build();
    }

    @Override
    public ParkingResponseDTO parkingToParkingResponseDTO(Parking parking) {
        return ParkingResponseDTO.builder()
                .parkingId(parking.getParkingId())
                .name(parking.getName())
                .capacity(parking.getCapacity())
                .nbVehicle(parking.getNbVehicle())
                .country(parking.getCountry())
                .city(parking.getCity())
                .governorate(parking.getGovernorate())
                .zipCode(parking.getZipCode())
                .latitude(parking.getLatitude())
                .longitude(parking.getLongitude())
                .build();
    }
}
