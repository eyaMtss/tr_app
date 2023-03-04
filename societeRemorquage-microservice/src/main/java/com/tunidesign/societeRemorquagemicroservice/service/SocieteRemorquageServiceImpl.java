package com.tunidesign.societeRemorquagemicroservice.service;



import com.tunidesign.societeRemorquagemicroservice.DTO.SocieteRemorquageRequestDTO;
import com.tunidesign.societeRemorquagemicroservice.DTO.SocieteRemorquageResponseDTO;
import com.tunidesign.societeRemorquagemicroservice.mapper.SocieteRemorquageMapper;
import com.tunidesign.societeRemorquagemicroservice.repository.SocieteRemorquageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SocieteRemorquageServiceImpl implements SocieteRemorquageService {

    @Autowired
    private SocieteRemorquageRepository societeRemorquageRepository;

    @Autowired
    private SocieteRemorquageMapper societeRemorquageMapper;
    @Override
    public List<SocieteRemorquageResponseDTO> getSocietes() {
        return societeRemorquageRepository.findAll().stream().map(garage -> societeRemorquageMapper.societeToSocieteResponseDTO(garage)).toList();
    }

    @Override
    public SocieteRemorquageResponseDTO getSocieteById(int id) {
        return societeRemorquageMapper.societeToSocieteResponseDTO(societeRemorquageRepository.findById(id));
    }

    @Override
    public SocieteRemorquageResponseDTO save(SocieteRemorquageRequestDTO societeRemorquageRequestDTO) {
       return societeRemorquageMapper.societeToSocieteResponseDTO(societeRemorquageRepository.save(societeRemorquageMapper.societeRequestDTOToSociete(societeRemorquageRequestDTO)));
    }

    @Override
    public void deleteSociete(int id) {
        societeRemorquageRepository.deleteById(id);

    }

    @Override
    public SocieteRemorquageResponseDTO update(SocieteRemorquageRequestDTO societeRemorquageRequestDTO) {
        return societeRemorquageMapper.societeToSocieteResponseDTO(societeRemorquageRepository.save(societeRemorquageMapper.societeRequestDTOToSociete(societeRemorquageRequestDTO)));
    }
}
