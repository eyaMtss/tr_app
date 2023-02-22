package com.example.agencemicroservice.mapper;

import com.example.agencemicroservice.DTO.AgenceRequestDTO;
import com.example.agencemicroservice.DTO.AgenceResponseDTO;
import com.example.agencemicroservice.model.Agence;
import org.springframework.stereotype.Component;

@Component
public class AgenceMapperImpl implements AgenceMapper {
    @Override
    public AgenceResponseDTO agenceToAgenceDTO(Agence agence) {
        return null;
    }
    @Override
    public Agence AgenceRequestDTOToAgence(AgenceRequestDTO agenceRequestDTO) {
        return null;
    }

}
