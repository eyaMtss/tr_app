package com.tunidesign.servicemicroservice.service;


import com.tunidesign.servicemicroservice.DTO.ServiceRequestDTO;
import com.tunidesign.servicemicroservice.DTO.ServiceResponseDTO;

import java.util.List;

public interface ServiceService {

        List<ServiceResponseDTO> getService();
        ServiceResponseDTO getService(String id);
        ServiceResponseDTO save(ServiceRequestDTO serviceRequestDTO);
        void deleteService( String id);
        ServiceResponseDTO update(ServiceRequestDTO serviceRequestDTO);
        List<ServiceResponseDTO> getServiceByPostId(String id);
}
