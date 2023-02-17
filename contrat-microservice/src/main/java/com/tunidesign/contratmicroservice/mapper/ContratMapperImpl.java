package com.tunidesign.contratmicroservice.mapper;

import com.tunidesign.contratmicroservice.DTO.ContratRequestDTO;
import com.tunidesign.contratmicroservice.DTO.ContratResponseDTO;
import com.tunidesign.contratmicroservice.model.Contrat;
import org.springframework.stereotype.Component;

@Component
public class ContratMapperImpl implements ContratMapper {
    @Override
    public ContratResponseDTO contratToContratDTO(Contrat contrat) {
        return null;
    }
    @Override
    public Contrat ContratRequestDTOToContrat(ContratRequestDTO contratRequestDTO) {
        return null;
    }

}
