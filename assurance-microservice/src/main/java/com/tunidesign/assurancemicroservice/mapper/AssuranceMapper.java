package com.tunidesign.assurancemicroservice.mapper;

import com.tunidesign.assurancemicroservice.DTO.AssuranceRequestDTO;
import com.tunidesign.assurancemicroservice.DTO.AssuranceResponseDTO;
import com.tunidesign.assurancemicroservice.model.Assurance;

public interface AssuranceMapper {
    AssuranceResponseDTO assuranceToAssuranceDTO(Assurance assurance);
    Assurance AssuranceRequestDTOToAssurance(AssuranceRequestDTO assuranceRequestDTO);
}
