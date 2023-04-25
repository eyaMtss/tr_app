package com.example.agencemicroservice.mapper;

import com.example.agencemicroservice.dto.AgenceRequestDto;
import com.example.agencemicroservice.dto.AgenceResponseDto;
import com.example.agencemicroservice.model.Agence;
import com.example.agencemicroservice.service.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AgenceMapperImpl implements AgenceMapper {
    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;
    @Override
    public AgenceResponseDto agenceToAgenceDto(Agence agence) {
        return AgenceResponseDto.builder()
                .id(agence.getId())
                .numero(agence.getNumero())
                .name(agence.getName())
                .telephone(agence.getTelephone())
                .responsable(agence.getResponsable())
                .email(agence.getEmail())
                .ville(agence.getVille())
                .paye(agence.getPaye())
                .gouvernerat(agence.getGouvernerat())
                .idAssurance(agence.getIdAssurance())
                .build();
    }
    @Override
    public Agence agenceRequestDtoToAgence(AgenceRequestDto agenceRequestDto) {
        return Agence.builder()
                .id(sequenceGeneratorService.generateSequence(Agence.SEQUENCE_NAME))
                .numero(agenceRequestDto.getNumero())
                .name(agenceRequestDto.getName())
                .telephone(agenceRequestDto.getTelephone())
                .responsable(agenceRequestDto.getResponsable())
                .email(agenceRequestDto.getEmail())
                .ville(agenceRequestDto.getVille())
                .paye(agenceRequestDto.getPaye())
                .gouvernerat(agenceRequestDto.getGouvernerat())
                .idAssurance(agenceRequestDto.getIdAssurance())
                .build();
    }

}
