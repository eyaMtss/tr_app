package com.example.agencemicroservice.mapper;

import com.example.agencemicroservice.DTO.AgenceRequestDTO;
import com.example.agencemicroservice.DTO.AgenceResponseDTO;
import com.example.agencemicroservice.model.Agence;
public interface AgenceMapper {
    AgenceResponseDTO agenceToAgenceDTO(Agence agence);
    Agence agenceRequestDTOToAgence(AgenceRequestDTO agenceRequestDTO);
}
