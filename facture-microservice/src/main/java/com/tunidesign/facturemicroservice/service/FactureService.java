package com.tunidesign.facturemicroservice.service;



import com.tunidesign.facturemicroservice.dto.FactureRequestDto;
import com.tunidesign.facturemicroservice.dto.FactureResponseDto;

import java.util.List;

public interface FactureService {

        List<FactureResponseDto> getFactures();
        FactureResponseDto getFacture(Long id);
        FactureResponseDto save(FactureRequestDto factureRequestDto);
        void deleteFacture(Long id);
        FactureResponseDto update(FactureRequestDto factureRequestDto);
}
