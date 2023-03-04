package com.tunidesign.societeRemorquagemicroservice.service;


import com.tunidesign.societeRemorquagemicroservice.DTO.SocieteRemorquageRequestDTO;
import com.tunidesign.societeRemorquagemicroservice.DTO.SocieteRemorquageResponseDTO;

import java.util.List;


public interface SocieteRemorquageService {
    List<SocieteRemorquageResponseDTO> getSocietes();
    SocieteRemorquageResponseDTO getSocieteById(int id);
    SocieteRemorquageResponseDTO save(SocieteRemorquageRequestDTO societeRemorquageRequestDTO);
    void deleteSociete(int id);
    SocieteRemorquageResponseDTO update(SocieteRemorquageRequestDTO societeRemorquageRequestDTO);
}
