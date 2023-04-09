package com.example.agencemicroservice.service;

import com.example.agencemicroservice.DTO.AgenceRequestDTO;
import com.example.agencemicroservice.DTO.AgenceResponseDTO;
import com.example.agencemicroservice.model.Agence;

import java.util.List;

public interface AgenceService {

        List<AgenceResponseDTO> getAgences();
        AgenceResponseDTO getAgence(Long id);
        AgenceResponseDTO save(AgenceRequestDTO agence);
        void deleteAgence(Long id);
        AgenceResponseDTO update(AgenceRequestDTO agenceRequestDTO);
}
