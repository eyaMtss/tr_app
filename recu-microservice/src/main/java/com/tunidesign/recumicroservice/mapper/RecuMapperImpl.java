package com.tunidesign.recumicroservice.mapper;

import com.tunidesign.recumicroservice.DTO.RecuRequestDTO;
import com.tunidesign.recumicroservice.DTO.RecuResponseDTO;
import com.tunidesign.recumicroservice.model.Recu;
import org.springframework.stereotype.Component;

@Component
public class RecuMapperImpl implements RecuMapper {
    @Override
    public RecuResponseDTO serviceToServiceDTO(Recu recu) {
        return null;
    }
    @Override
    public Recu RecuRequestDTOToRecu(RecuRequestDTO recuRequestDTO) {
        return null;
    }

}
