package com.tunidesign.contratmicroservice.mapper;

import com.tunidesign.contratmicroservice.dto.ContratRequestDto;
import com.tunidesign.contratmicroservice.dto.ContratResponseDto;
import com.tunidesign.contratmicroservice.model.Contrat;

public interface ContratMapper {
    ContratResponseDto contratToContratDto(Contrat contrat);
    Contrat contratRequestDtoToContrat(ContratRequestDto contratRequestDTO);
}
