package com.tunidesign.parkingmicroservice.service;

import com.tunidesign.parkingmicroservice.DTO.ParkingRequestDTO;
import com.tunidesign.parkingmicroservice.DTO.ParkingResponseDTO;
import com.tunidesign.parkingmicroservice.mapper.ParkingMapper;
import com.tunidesign.parkingmicroservice.mapper.ParkingMapperImpl;
import com.tunidesign.parkingmicroservice.model.Parking;
import com.tunidesign.parkingmicroservice.repository.ParkingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ParkingServiceImpl implements ParkingService{
    @Autowired
    private ParkingRepository parkingRepository;
    private ParkingMapperImpl parkingMapper;
    @Override
    public ParkingResponseDTO addParking(ParkingRequestDTO parkingRequestDTO) {
        return parkingMapper.parkingToParkingResponseDTO(parkingRepository.save(parkingMapper.parkingResquestDTOToParking(parkingRequestDTO)));
    }

    @Override
    public ParkingResponseDTO updateParking(Long parkingId, ParkingRequestDTO parkingRequestDTO) {
        Parking existingParking = parkingRepository.findById(parkingId).get();
        existingParking.setName(parkingRequestDTO.getName());
        existingParking.setCapacity(parkingRequestDTO.getCapacity());
        existingParking.setNbVehicle(parkingRequestDTO.getNbVehicle());
        existingParking.setCountry(parkingRequestDTO.getCountry());
        existingParking.setGovernorate(parkingRequestDTO.getGovernorate());
        existingParking.setCity(parkingRequestDTO.getCity());
        existingParking.setZipCode(parkingRequestDTO.getZipCode());
        existingParking.setLatitude(parkingRequestDTO.getLatitude());
        existingParking.setLongitude(parkingRequestDTO.getLongitude());
        existingParking.setGarageId(parkingRequestDTO.getGarageId());
        return parkingMapper.parkingToParkingResponseDTO(parkingRepository.save(existingParking));
    }

    @Override
    public List<ParkingResponseDTO> getParkings() {
        return parkingRepository.findAll()
                .stream()
                .map(parking -> parkingMapper.parkingToParkingResponseDTO(parking))
                .toList();
    }

    @Override
    public List<ParkingResponseDTO> getParkingsByGarage(Long garageId) {
        return parkingRepository.findAllByGarageId(garageId)
                .stream()
                .map(parking -> parkingMapper.parkingToParkingResponseDTO(parking))
                .toList();
    }

    @Override
    public ParkingResponseDTO getParkingById(Long parkingId) {
        return parkingMapper.parkingToParkingResponseDTO(parkingRepository.findById(parkingId).get());
    }

    @Override
    public void deleteParking(Long parkingId) {
        parkingRepository.deleteById(parkingId);
    }

    @Override
    public Boolean isExist(Long parkingId) {
        return parkingRepository.findById(parkingId).isPresent();
    }
}
