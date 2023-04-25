package com.tunidesign.contratmicroservice.service;

import com.tunidesign.contratmicroservice.dto.ContratRequestDto;
import com.tunidesign.contratmicroservice.dto.ContratResponseDto;
import com.tunidesign.contratmicroservice.dto.VerifyContractRequestDto;
import com.tunidesign.contratmicroservice.mapper.ContratMapper;
import com.tunidesign.contratmicroservice.mapper.ContratMapperImpl;
import com.tunidesign.contratmicroservice.model.Contrat;
import com.tunidesign.contratmicroservice.repository.ContratRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContratServiceImpl implements ContratService {
    @Autowired
    private ContratRepository contratRepository;
    private ContratMapper contratMapper = new ContratMapperImpl();

    @Override
    public List<ContratResponseDto> getContrats() {
        return contratRepository.findAll().stream().map(contrat -> contratMapper.contratToContratDto(contrat)).toList();
    }

    @Override
    public ContratResponseDto getContrat(Long id) {
        if (contratRepository.findById(id).isPresent()) {
            return contratMapper.contratToContratDto(contratRepository.findById(id).get());
        }
        else return null;
    }

    @Override
    public ContratResponseDto save(ContratRequestDto contratRequestDTO) {
        return null;
    }

    @Override
    public void deleteContrat(Long id) {
        contratRepository.deleteById(id);
    }
    @Override
    public ContratResponseDto update(ContratRequestDto contratRequestDTO) {
        return null;
    }

    @Override
    public Boolean verifyContract(VerifyContractRequestDto verifyContractRequestDTO) {
        Contrat contrat = contratRepository.findByNumContrat(verifyContractRequestDTO.getNumContrat());
        return contrat != null;
    }

    @Override
    public Boolean isExist(Long id) {
        return contratRepository.findById(id).isPresent();
    }

}
