package com.tunidesign.recumicroservice.mapper;


import com.tunidesign.recumicroservice.DTO.RecuRequestDTO;
import com.tunidesign.recumicroservice.DTO.RecuResponseDTO;
import com.tunidesign.recumicroservice.model.Recu;


public interface RecuMapper {
    RecuResponseDTO serviceToServiceDTO(Recu recu);
    Recu RecuRequestDTOToRecu(RecuRequestDTO recuRequestDTO);
}
