package com.tunidesign.servicemicroservice.mapper;

import com.tunidesign.servicemicroservice.DTO.ServiceRequestDTO;
import com.tunidesign.servicemicroservice.DTO.ServiceResponseDTO;
import com.tunidesign.servicemicroservice.model.Service;
import org.springframework.stereotype.Component;

@Component
public class ServiceMapperImpl implements ServiceMapper {
    @Override
    public ServiceResponseDTO serviceToServiceDTO(Service service) {
        return null;
    }
    @Override
    public Service ServiceRequestDTOToService(ServiceRequestDTO serviceRequestDTO) {
        return null;
    }

}
