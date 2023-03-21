package com.tunidesign.societeRemorquagemicroservice.mapper;



import com.tunidesign.societeRemorquagemicroservice.DTO.SocieteRemorquageRequestDTO;
import com.tunidesign.societeRemorquagemicroservice.DTO.SocieteRemorquageResponseDTO;
import com.tunidesign.societeRemorquagemicroservice.model.SocieteRemorquage;

public interface SocieteRemorquageMapper {
    SocieteRemorquageResponseDTO societeToSocieteResponseDTO(SocieteRemorquage societeRemorquage);
    SocieteRemorquage societeRequestDTOToSociete(SocieteRemorquageRequestDTO societeRemorquageRequestDTO);
}
