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
    @Autowired
    private AgenceMapper agenceMapper;

    @Override
    public List<AgenceResponseDTO> getAgences() {
        return agenceRepository.findAll().stream().map(agence -> agenceMapper.agenceToAgenceDTO(agence)).toList();
    }

    @Override
    public AgenceResponseDTO getAgence(Long id) {
        return agenceMapper.agenceToAgenceDTO(agenceRepository.findById(id).get());
    }

    @Override
    public AgenceResponseDTO save(AgenceRequestDTO agenceRequestDTO) {
        return agenceMapper.agenceToAgenceDTO(agenceRepository.save(agenceMapper.agenceRequestDTOToAgence(agenceRequestDTO)));
    }

    @Override
    public void deleteAgence(Long id) {
        agenceRepository.deleteById(id);
    }

    @Override
    public AgenceResponseDTO update(AgenceRequestDTO agenceRequestDTO) {
        return agenceMapper.agenceToAgenceDTO(agenceRepository.save(agenceMapper.agenceRequestDTOToAgence(agenceRequestDTO)));
    }

    @Override
    public List<AgenceResponseDTO> getByInsurance(Long idAssurance) {
        return agenceRepository.findByIdAssurance(idAssurance).stream()
                .map(agency -> agenceMapper.agenceToAgenceDTO(agency))
                .toList();
    }

}
