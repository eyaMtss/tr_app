package com.example.agencemicroservice.service;

import com.example.agencemicroservice.dto.AgenceRequestDto;
import com.example.agencemicroservice.dto.AgenceResponseDto;

import java.util.List;

public interface AgenceService {

        List<AgenceResponseDto> getAgences();
        AgenceResponseDto getAgence(Long id);
        AgenceResponseDto save(AgenceRequestDto agence);
        void deleteAgence(Long id);
        AgenceResponseDto update(AgenceRequestDto agenceRequestDTO);
        List<AgenceResponseDto> getByInsurance(Long idAssurance);
}
