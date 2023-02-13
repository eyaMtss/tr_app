package com.example.agencemicroservice.service;

import com.example.agencemicroservice.DTO.AgenceRequestDTO;
import com.example.agencemicroservice.DTO.AgenceResponseDTO;

import java.util.List;

public interface AgenceService {

        List<AgenceResponseDTO> getOrder();
        AgenceResponseDTO getOrder(String id);
        AgenceResponseDTO save(AgenceRequestDTO agenceRequestDTO);
        void deleteOrder( String id);
        AgenceResponseDTO update(AgenceRequestDTO agenceRequestDTO);
        List <AgenceResponseDTO> getAgenceByPostId(String id);
}
