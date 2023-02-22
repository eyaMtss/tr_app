package com.tunidesign.facturemicroservice.service;

import com.tunidesign.facturemicroservice.DTO.FactureRequestDTO;
import com.tunidesign.facturemicroservice.DTO.FactureResponseDTO;
import com.tunidesign.facturemicroservice.mapper.FactureMapper;
import com.tunidesign.facturemicroservice.repository.FactureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FactureServiceImpl implements FactureService {
    @Autowired
    private FactureRepository factureRepository;
    private FactureMapper FactureMapper;

    @Override
    public List<FactureResponseDTO> getFacture() {
        return null;
    }

    @Override
    public FactureResponseDTO getFacture(String id) {
        return null;
    }

    @Override
    public FactureResponseDTO save(FactureRequestDTO factureRequestDTO) {
        return null;
    }

    @Override
    public void deleteFacture(String id) {

    }

    @Override
    public FactureResponseDTO update(FactureRequestDTO factureRequestDTO) {
        return null;
    }

    @Override
    public List<FactureResponseDTO> getFactureByPostId(String id) {
        return null;
    }
}
