package com.tunidesign.assurancemicroservice.service;

import com.tunidesign.assurancemicroservice.DTO.AssuranceRequestDTO;
import com.tunidesign.assurancemicroservice.DTO.AssuranceResponseDTO;

import java.util.List;

public interface AssuranceService {

        List<AssuranceResponseDTO> getInsurances();
        AssuranceResponseDTO getAssurance(Long id);
        AssuranceResponseDTO save(AssuranceRequestDTO assuranceRequestDTO);
        void deleteAssurance(Long id);
        AssuranceResponseDTO update(AssuranceRequestDTO assuranceRequestDTO);
}
