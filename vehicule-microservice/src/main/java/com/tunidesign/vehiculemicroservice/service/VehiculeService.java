package com.tunidesign.vehiculemicroservice.service;



import com.tunidesign.vehiculemicroservice.DTO.VehiculeRequestDTO;
import com.tunidesign.vehiculemicroservice.DTO.VehiculeResponseDTO;

import java.util.List;

public interface VehiculeService {

        List<VehiculeResponseDTO> getVehicule();
        VehiculeResponseDTO getVehicule(String id);
        VehiculeResponseDTO save(VehiculeRequestDTO vehiculeRequestDTO);
        void deleteVehicule( String id);
        VehiculeResponseDTO update(VehiculeRequestDTO vehiculeRequestDTO);
        List <VehiculeResponseDTO> getVehiculeByPostId(String id);
}
