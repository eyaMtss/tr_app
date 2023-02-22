package com.tunidesign.contratmicroservice.service;

import com.tunidesign.contratmicroservice.DTO.ContratRequestDTO;
import com.tunidesign.contratmicroservice.DTO.ContratResponseDTO;
import com.tunidesign.contratmicroservice.mapper.ContratMapper;
import com.tunidesign.contratmicroservice.repository.ContratRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContratServiceImpl implements ContratService {
    @Autowired
    private ContratRepository contratRepository;
    private ContratMapper contratMapper;

    @Override
    public List<ContratResponseDTO> getContrat() {
        return null;
    }

    @Override
    public ContratResponseDTO getContrat(String id) {
        return null;
    }

    @Override
    public ContratResponseDTO save(ContratRequestDTO contratRequestDTO) {
        return null;
    }

    @Override
    public void deleteContrat(String id) {

    }
    @Override
    public ContratResponseDTO update(ContratRequestDTO contratRequestDTO) {
        return null;
    }

    @Override
    public List<ContratResponseDTO> getContratByPostId(String id) {
        return null;
    }
}
