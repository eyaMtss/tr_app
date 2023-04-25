package com.tunidesign.facturemicroservice.service;

import com.tunidesign.facturemicroservice.dto.FactureRequestDto;
import com.tunidesign.facturemicroservice.dto.FactureResponseDto;
import com.tunidesign.facturemicroservice.mapper.FactureMapper;
import com.tunidesign.facturemicroservice.mapper.FactureMapperImpl;
import com.tunidesign.facturemicroservice.model.Facture;
import com.tunidesign.facturemicroservice.repository.FactureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FactureServiceImpl implements FactureService {
    @Autowired
    private FactureRepository factureRepository;
    private final FactureMapper factureMapper = new FactureMapperImpl();

    @Override
    public List<FactureResponseDto> getFactures() {
        return factureRepository.findAll().stream().map(agence -> factureMapper.factureToFactureDto(agence)).toList();
    }

    @Override
    public FactureResponseDto getFacture(Long id) {
        return factureRepository.findById(id).isPresent() ? factureMapper.factureToFactureDto(factureRepository.findById(id).get()) : null;
    }

    @Override
    public FactureResponseDto save(FactureRequestDto factureRequestDto) {
        return factureMapper.factureToFactureDto(factureRepository.save(factureMapper.factureRequestDtoToFacture(factureRequestDto)));
    }

    @Override
    public void deleteFacture(Long id) {
        factureRepository.deleteById(id);
    }

    @Override
    public FactureResponseDto update(FactureRequestDto factureRequestDto) {
        if(factureRepository.findById(factureRequestDto.getId()).isPresent()){
            Facture existingFacture = factureRepository.findById(factureRequestDto.getId()).get();
            factureRequestDto.setId(existingFacture.getId());
            return factureMapper.factureToFactureDto(factureRepository.save(factureMapper.factureRequestDtoToFacture(factureRequestDto)));
        }
        else return null;
    }

}
