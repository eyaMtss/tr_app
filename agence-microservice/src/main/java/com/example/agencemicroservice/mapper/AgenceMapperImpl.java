package com.example.agencemicroservice.mapper;

import com.example.agencemicroservice.DTO.AgenceRequestDTO;
import com.example.agencemicroservice.DTO.AgenceResponseDTO;
import com.example.agencemicroservice.model.Agence;
import com.example.agencemicroservice.service.SequenceGeneratorService;
import jakarta.validation.constraints.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AgenceMapperImpl implements AgenceMapper {
    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;
    @Override
    public AgenceResponseDTO agenceToAgenceDTO(Agence agence) {
        return AgenceResponseDTO.builder()
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
    public Agence agenceRequestDTOToAgence(AgenceRequestDTO agenceRequestDTO) {
        return Agence.builder()
                .id(sequenceGeneratorService.generateSequence(Agence.SEQUENCE_NAME))
                .numero(agenceRequestDTO.getNumero())
                .name(agenceRequestDTO.getName())
                .telephone(agenceRequestDTO.getTelephone())
                .responsable(agenceRequestDTO.getResponsable())
                .email(agenceRequestDTO.getEmail())
                .ville(agenceRequestDTO.getVille())
                .paye(agenceRequestDTO.getPaye())
                .gouvernerat(agenceRequestDTO.getGouvernerat())
                .idAssurance(agenceRequestDTO.getIdAssurance())
                .build();
    }

}
