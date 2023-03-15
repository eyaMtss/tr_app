package com.tunidesign.contratmicroservice.service;

import com.tunidesign.contratmicroservice.DTO.ContratRequestDTO;
import com.tunidesign.contratmicroservice.DTO.ContratResponseDTO;
import com.tunidesign.contratmicroservice.DTO.VerifyContractRequestDTO;

import java.util.List;

public interface ContratService {

        List<ContratResponseDTO> getContrat();
        ContratResponseDTO getContrat(Long id);
        ContratResponseDTO save(ContratRequestDTO contratRequestDTO);
        void deleteContrat(Long id);
        ContratResponseDTO update(ContratRequestDTO contratRequestDTO);
        Boolean verifyContract(VerifyContractRequestDTO verifyContractRequestDTO);

}
