package com.tunidesign.facturemicroservice.mapper;

import com.tunidesign.facturemicroservice.dto.FactureRequestDto;
import com.tunidesign.facturemicroservice.dto.FactureResponseDto;
import com.tunidesign.facturemicroservice.model.Facture;

public interface FactureMapper {
    FactureResponseDto factureToFactureDto(Facture facture);
    Facture factureRequestDtoToFacture(FactureRequestDto factureRequestDto);
}
