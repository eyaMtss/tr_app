package com.tunidesign.societeRemorquagemicroservice.mapper;


import com.tunidesign.societeRemorquagemicroservice.DTO.SocieteRemorquageRequestDTO;
import com.tunidesign.societeRemorquagemicroservice.DTO.SocieteRemorquageResponseDTO;
import com.tunidesign.societeRemorquagemicroservice.model.SocieteRemorquage;
import org.springframework.stereotype.Component;


@Component
public class SocieteRemorquageMapperImpl implements SocieteRemorquageMapper {
    @Override
    public SocieteRemorquageResponseDTO societeToSocieteResponseDTO(SocieteRemorquage societeRemorquage) {
        return SocieteRemorquageResponseDTO.builder().id(societeRemorquage.getId())
                .adresse(societeRemorquage.getAdresse()).build();

    }

    @Override
    public SocieteRemorquage societeRequestDTOToSociete(SocieteRemorquageRequestDTO societeRemorquageRequestDTO) {
        return SocieteRemorquage.builder().id(societeRemorquageRequestDTO.getId())
                .adresse(societeRemorquageRequestDTO.getAdresse()).build();

    }
}
