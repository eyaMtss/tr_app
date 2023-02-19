package com.tunidesign.servicemicroservice.service;

import com.tunidesign.servicemicroservice.DTO.ServiceRequestDTO;
import com.tunidesign.servicemicroservice.DTO.ServiceResponseDTO;
import com.tunidesign.servicemicroservice.mapper.ServiceMapper;
import com.tunidesign.servicemicroservice.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceServiceImpl implements ServiceService {
    @Autowired
    private ServiceRepository serviceRepository;
    private ServiceMapper serviceMapper;

    @Override
    public List<ServiceResponseDTO> getService() {
        return null;
    }

    @Override
    public ServiceResponseDTO getService(String id) {
        return null;
    }

    @Override
    public ServiceResponseDTO save(ServiceRequestDTO serviceRequestDTO) {
        return null;
    }

    @Override
    public void deleteService(String id) {

    }

    @Override
    public ServiceResponseDTO update(ServiceRequestDTO serviceRequestDTO) {
        return null;
    }

    @Override
    public List<ServiceResponseDTO> getServiceByPostId(String id) {
        return null;
    }
}
