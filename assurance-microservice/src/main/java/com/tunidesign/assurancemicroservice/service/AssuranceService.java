package com.tunidesign.assurancemicroservice.service;

import com.tunidesign.assurancemicroservice.DTO.AssuranceRequestDTO;
import com.tunidesign.assurancemicroservice.DTO.AssuranceResponseDTO;

import java.util.List;

public interface AssuranceService {

        List<AssuranceResponseDTO> getAssurance();
        AssuranceResponseDTO getAssurance(String id);
        AssuranceResponseDTO save(AssuranceRequestDTO assuranceRequestDTO);
        void deleteAssurance( String id);
        AssuranceResponseDTO update(AssuranceRequestDTO assuranceRequestDTO);
        List <AssuranceResponseDTO> getAssuranceByPostId(String id);
}
