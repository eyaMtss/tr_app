package com.example.agencemicroservice.mapper;

import com.example.agencemicroservice.dto.AgenceRequestDto;
import com.example.agencemicroservice.dto.AgenceResponseDto;
import com.example.agencemicroservice.model.Agence;
public interface AgenceMapper {
    AgenceResponseDto agenceToAgenceDto(Agence agence);
    Agence agenceRequestDtoToAgence(AgenceRequestDto agenceRequestDTO);
}
