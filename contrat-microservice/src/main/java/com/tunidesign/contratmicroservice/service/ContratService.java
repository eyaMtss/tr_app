package com.tunidesign.contratmicroservice.service;

import com.tunidesign.contratmicroservice.DTO.ContratRequestDTO;
import com.tunidesign.contratmicroservice.DTO.ContratResponseDTO;

import java.util.List;

public interface ContratService {

        List<ContratResponseDTO> getContrat();
        ContratResponseDTO getContrat(String id);
        ContratResponseDTO save(ContratRequestDTO contratRequestDTO);
        void deleteContrat( String id);
        ContratResponseDTO update(ContratRequestDTO contratRequestDTO);
        List <ContratResponseDTO> getContratByPostId(String id);
}
