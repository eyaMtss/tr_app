package com.tunidesign.facturemicroservice.mapper;

import com.tunidesign.facturemicroservice.dto.FactureRequestDto;
import com.tunidesign.facturemicroservice.dto.FactureResponseDto;
import com.tunidesign.facturemicroservice.model.Facture;
import org.springframework.stereotype.Component;

@Component
public class FactureMapperImpl implements FactureMapper {
    @Override
    public FactureResponseDto factureToFactureDto(Facture facture) {
        return null;
    }
    @Override
    public Facture factureRequestDtoToFacture(FactureRequestDto factureRequestDto) {
        return null;
    }

}
