package com.tunidesign.vehiculemicroservice.service;



import com.tunidesign.vehiculemicroservice.DTO.VehiculeRequestDTO;
import com.tunidesign.vehiculemicroservice.DTO.VehiculeResponseDTO;

import java.util.List;

public interface VehiculeService {

        List<VehiculeResponseDTO> getVehicles();
        VehiculeResponseDTO getVehicle(Long id);
        VehiculeResponseDTO save(VehiculeRequestDTO vehiculeRequestDTO);
        void deleteVehicle(Long id);
        VehiculeResponseDTO updateVehicle(VehiculeRequestDTO vehiculeRequestDTO);
        Boolean isExist(Long id);
}
