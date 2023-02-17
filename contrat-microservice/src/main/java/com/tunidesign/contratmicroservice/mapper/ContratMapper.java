package com.tunidesign.contratmicroservice.mapper;

import com.tunidesign.contratmicroservice.DTO.ContratRequestDTO;
import com.tunidesign.contratmicroservice.DTO.ContratResponseDTO;
import com.tunidesign.contratmicroservice.model.Contrat;

public interface ContratMapper {
    ContratResponseDTO contratToContratDTO(Contrat contrat);
    Contrat ContratRequestDTOToContrat(ContratRequestDTO contratRequestDTO);
}
