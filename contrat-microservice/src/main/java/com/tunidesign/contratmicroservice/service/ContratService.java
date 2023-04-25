package com.tunidesign.contratmicroservice.service;

import com.tunidesign.contratmicroservice.dto.ContratRequestDto;
import com.tunidesign.contratmicroservice.dto.ContratResponseDto;
import com.tunidesign.contratmicroservice.dto.VerifyContractRequestDto;

import java.util.List;
import java.util.Optional;

public interface ContratService {

        List<ContratResponseDto> getContrats();
        ContratResponseDto getContrat(Long id);
        ContratResponseDto save(ContratRequestDto contratRequestDTO);
        void deleteContrat(Long id);
        ContratResponseDto update(ContratRequestDto contratRequestDTO);
        Boolean verifyContract(VerifyContractRequestDto verifyContractRequestDTO);
        Boolean isExist(Long id);

}
