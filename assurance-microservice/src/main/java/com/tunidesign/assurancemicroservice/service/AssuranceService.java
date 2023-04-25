package com.tunidesign.assurancemicroservice.service;

import com.tunidesign.assurancemicroservice.dto.AssuranceRequestDto;
import com.tunidesign.assurancemicroservice.dto.AssuranceResponseDto;

import java.util.List;

public interface AssuranceService {

        List<AssuranceResponseDto> getInsurances();
        AssuranceResponseDto getAssurance(Long id);
        AssuranceResponseDto save(AssuranceRequestDto assuranceRequestDTO);
        void deleteAssurance(Long id);
        AssuranceResponseDto update(AssuranceRequestDto assuranceRequestDTO);
}
