package com.tunidesign.assurancemicroservice.mapper;

import com.tunidesign.assurancemicroservice.DTO.AssuranceRequestDTO;
import com.tunidesign.assurancemicroservice.DTO.AssuranceResponseDTO;
import com.tunidesign.assurancemicroservice.model.Assurance;
import org.springframework.stereotype.Component;

@Component
public class AssuranceMapperImpl implements AssuranceMapper {
    @Override
    public AssuranceResponseDTO assuranceToAssuranceDTO(Assurance assurance) {
        return null;
    }

    @Override
    public Assurance AssuranceRequestDTOToAssurance(AssuranceRequestDTO assuranceRequestDTO) {
        return null;
    }

}
