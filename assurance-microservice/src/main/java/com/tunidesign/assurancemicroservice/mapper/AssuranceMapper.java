package com.tunidesign.assurancemicroservice.mapper;

import com.tunidesign.assurancemicroservice.dto.AssuranceRequestDto;
import com.tunidesign.assurancemicroservice.dto.AssuranceResponseDto;
import com.tunidesign.assurancemicroservice.model.Assurance;

public interface AssuranceMapper {
    AssuranceResponseDto assuranceToAssuranceDto(Assurance assurance);
    Assurance assuranceRequestDtoToAssurance(AssuranceRequestDto assuranceRequestDto);
}
