package com.tunidesign.recumicroservice.service;


import com.tunidesign.recumicroservice.DTO.RecuRequestDTO;
import com.tunidesign.recumicroservice.DTO.RecuResponseDTO;
import java.util.List;

public interface RecuService {

        List<RecuResponseDTO> getRecu();
        RecuResponseDTO getRecu(String id);
        RecuResponseDTO save(RecuRequestDTO recuRequestDTO);
        void deleteRecu( String id);
        RecuResponseDTO update(RecuRequestDTO recuRequestDTO);
        List<RecuResponseDTO> getRecuByPostId(String id);
}
