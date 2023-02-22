package com.example.agencemicroservice.service;

import com.example.agencemicroservice.DTO.AgenceRequestDTO;
import com.example.agencemicroservice.DTO.AgenceResponseDTO;
import com.example.agencemicroservice.mapper.AgenceMapper;
import com.example.agencemicroservice.repository.AgenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgenceServiceImpl implements AgenceService {
    @Autowired
    private AgenceRepository agenceRepository;
    private AgenceMapper orderMapper;

    @Override
    public List<AgenceResponseDTO> getOrder() {
        return null;
    }

    @Override
    public AgenceResponseDTO getOrder(String id) {
        return null;
    }

    @Override
    public AgenceResponseDTO save(AgenceRequestDTO agenceRequestDTO) {
        return null;
    }

    @Override
    public void deleteOrder(String id) {

    }

    @Override
    public AgenceResponseDTO update(AgenceRequestDTO agenceRequestDTO) {
        return null;
    }

    @Override
    public List<AgenceResponseDTO> getAgenceByPostId(String id) {
        return null;
    }
}
