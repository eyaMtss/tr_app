package com.example.agencemicroservice.service;

import com.example.agencemicroservice.dto.AgenceRequestDto;
import com.example.agencemicroservice.dto.AgenceResponseDto;
import com.example.agencemicroservice.mapper.AgenceMapper;
import com.example.agencemicroservice.mapper.AgenceMapperImpl;
import com.example.agencemicroservice.repository.AgenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgenceServiceImpl implements AgenceService {
    @Autowired
    private AgenceRepository agenceRepository;
    @Autowired
    private final AgenceMapper agenceMapper = new AgenceMapperImpl();

    @Override
    public List<AgenceResponseDto> getAgences() {
        return agenceRepository.findAll().stream().map(agence -> agenceMapper.agenceToAgenceDto(agence)).toList();
    }

    @Override
    public AgenceResponseDto getAgence(Long id) {
        return agenceRepository.findById(id).isPresent() ? agenceMapper.agenceToAgenceDto(agenceRepository.findById(id).get()) : null;
    }

    @Override
    public AgenceResponseDto save(AgenceRequestDto agenceRequestDto) {
        return agenceMapper.agenceToAgenceDto(agenceRepository.save(agenceMapper.agenceRequestDtoToAgence(agenceRequestDto)));
    }

    @Override
    public void deleteAgence(Long id) {
        agenceRepository.deleteById(id);
    }

    @Override
    public AgenceResponseDto update(AgenceRequestDto agenceRequestDTO) {
        return agenceMapper.agenceToAgenceDto(agenceRepository.save(agenceMapper.agenceRequestDtoToAgence(agenceRequestDTO)));
    }

    @Override
    public List<AgenceResponseDto> getByInsurance(Long idAssurance) {
        return agenceRepository.findByIdAssurance(idAssurance).stream()
                .map(agency -> agenceMapper.agenceToAgenceDto(agency))
                .toList();
    }

}
