package com.tunidesign.contratmicroservice.mapper;

import com.tunidesign.contratmicroservice.dto.ContratRequestDto;
import com.tunidesign.contratmicroservice.dto.ContratResponseDto;
import com.tunidesign.contratmicroservice.model.Contrat;
import org.springframework.stereotype.Component;

@Component
public class ContratMapperImpl implements ContratMapper {
    @Override
    public ContratResponseDto contratToContratDto(Contrat contrat) {
        return null;
    }
    @Override
    public Contrat contratRequestDtoToContrat(ContratRequestDto contratRequestDTO) {
        return null;
    }

}
