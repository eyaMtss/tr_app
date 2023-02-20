package com.tunidesign.recumicroservice.service;

import com.tunidesign.recumicroservice.DTO.RecuRequestDTO;
import com.tunidesign.recumicroservice.DTO.RecuResponseDTO;
import com.tunidesign.recumicroservice.mapper.RecuMapper;
import com.tunidesign.recumicroservice.repository.RecuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecuServiceImpl implements RecuService {
    @Autowired
    private RecuRepository RecuRepository;
    private RecuMapper recuMapper;
    @Override
    public List<RecuResponseDTO> getRecu() {
        return null;
    }
    @Override
    public RecuResponseDTO getRecu(String id) {
        return null;
    }
    @Override
    public RecuResponseDTO save(RecuRequestDTO recuRequestDTO) {
        return null;
    }
    @Override
    public void deleteRecu(String id) {
    }
    @Override
    public RecuResponseDTO update(RecuRequestDTO recuRequestDTO) {
        return null;
    }
    @Override
    public List<RecuResponseDTO> getRecuByPostId(String id) {
        return null;
    }
}
