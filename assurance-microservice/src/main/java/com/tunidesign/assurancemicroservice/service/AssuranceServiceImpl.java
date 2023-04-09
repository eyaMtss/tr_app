package com.tunidesign.assurancemicroservice.service;

import com.tunidesign.assurancemicroservice.DTO.AssuranceRequestDTO;
import com.tunidesign.assurancemicroservice.DTO.AssuranceResponseDTO;
import com.tunidesign.assurancemicroservice.mapper.AssuranceMapper;
import com.tunidesign.assurancemicroservice.mapper.AssuranceMapperImpl;
import com.tunidesign.assurancemicroservice.repository.AssuranceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssuranceServiceImpl implements AssuranceService {
    @Autowired
    private AssuranceRepository  assuranceRepository;
    private AssuranceMapper assuranceMapper = new AssuranceMapperImpl();

    @Override
    public List<AssuranceResponseDTO> getInsurances() {
        return assuranceRepository.findAll()
                .stream()
                .map(assurance -> assuranceMapper.assuranceToAssuranceDTO(assurance)).toList();
    }

    @Override
    public AssuranceResponseDTO getAssurance(Long id) {
        return null;
    }

    @Override
    public AssuranceResponseDTO save(AssuranceRequestDTO assuranceRequestDTO) {
        return null;
    }

    @Override
    public void deleteAssurance(Long id) {
        assuranceRepository.deleteById(id);
    }

    @Override
    public AssuranceResponseDTO update(AssuranceRequestDTO assuranceRequestDTO) {
        return null;
    }
}
