package com.tunidesign.servicemicroservice.mapper;


import com.tunidesign.servicemicroservice.DTO.ServiceRequestDTO;
import com.tunidesign.servicemicroservice.DTO.ServiceResponseDTO;
import com.tunidesign.servicemicroservice.model.Service;

public interface ServiceMapper {
    ServiceResponseDTO serviceToServiceDTO(Service service);
    Service ServiceRequestDTOToService(ServiceRequestDTO serviceRequestDTO);
}
