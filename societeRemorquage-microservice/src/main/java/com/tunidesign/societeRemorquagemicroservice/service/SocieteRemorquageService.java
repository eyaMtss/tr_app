package com.tunidesign.societeRemorquagemicroservice.service;


import com.tunidesign.societeRemorquagemicroservice.DTO.SocieteRemorquageRequestDTO;
import com.tunidesign.societeRemorquagemicroservice.DTO.SocieteRemorquageResponseDTO;

import java.util.List;


public interface SocieteRemorquageService {
    List<SocieteRemorquageResponseDTO> getSocietes();
    SocieteRemorquageResponseDTO getSocieteById(Long id);
    SocieteRemorquageResponseDTO save(SocieteRemorquageRequestDTO societeRemorquageRequestDTO);
    void deleteSociete(Long id);
    SocieteRemorquageResponseDTO update(SocieteRemorquageRequestDTO societeRemorquageRequestDTO);
    Boolean isExist(Long id);
}
