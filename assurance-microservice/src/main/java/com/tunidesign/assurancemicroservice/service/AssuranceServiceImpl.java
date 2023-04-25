package com.tunidesign.assurancemicroservice.service;

import com.tunidesign.assurancemicroservice.dto.AssuranceRequestDto;
import com.tunidesign.assurancemicroservice.dto.AssuranceResponseDto;
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
    private final AssuranceMapper assuranceMapper = new AssuranceMapperImpl();

    @Override
    public List<AssuranceResponseDto> getInsurances() {
        return assuranceRepository.findAll()
                .stream()
                .map(assurance -> assuranceMapper.assuranceToAssuranceDto(assurance)).toList();
    }

    @Override
    public AssuranceResponseDto getAssurance(Long id) {
        return assuranceRepository.findById(id).isPresent() ? assuranceMapper.assuranceToAssuranceDto(assuranceRepository.findById(id).get()) : null;
    }

    @Override
    public AssuranceResponseDto save(AssuranceRequestDto assuranceRequestDTO) {
        return null;
    }

    @Override
    public void deleteAssurance(Long id) {
        assuranceRepository.deleteById(id);
    }

    @Override
    public AssuranceResponseDto update(AssuranceRequestDto assuranceRequestDTO) {
        return null;
    }
}
