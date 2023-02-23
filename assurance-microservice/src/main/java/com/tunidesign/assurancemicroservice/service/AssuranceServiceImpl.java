package com.tunidesign.assurancemicroservice.service;

import com.tunidesign.assurancemicroservice.DTO.AssuranceRequestDTO;
import com.tunidesign.assurancemicroservice.DTO.AssuranceResponseDTO;
import com.tunidesign.assurancemicroservice.mapper.AssuranceMapper;
import com.tunidesign.assurancemicroservice.repository.AssuranceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssuranceServiceImpl implements AssuranceService {
    @Autowired
    private AssuranceRepository  assuranceRepository;
    private AssuranceMapper assuranceMapper;

    @Override
    public List<AssuranceResponseDTO> getAssurance() {
        return null;
    }

    @Override
    public AssuranceResponseDTO getAssurance(String id) {
        return null;
    }

    @Override
    public AssuranceResponseDTO save(AssuranceRequestDTO assuranceRequestDTO) {
        return null;
    }

    @Override
    public void deleteAssurance(String id) {

    }

    @Override
    public AssuranceResponseDTO update(AssuranceRequestDTO assuranceRequestDTO) {
        return null;
    }

    @Override
    public List<AssuranceResponseDTO> getAssuranceByPostId(String id) {
        return null;
    }
}
