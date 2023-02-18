package com.tunidesign.facturemicroservice.mapper;

import com.tunidesign.facturemicroservice.DTO.FactureRequestDTO;
import com.tunidesign.facturemicroservice.DTO.FactureResponseDTO;
import com.tunidesign.facturemicroservice.model.Facture;
import org.springframework.stereotype.Component;

@Component
public class FactureMapperImpl implements FactureMapper {
    @Override
    public FactureResponseDTO factureToFactureDTO(Facture facture) {
        return null;
    }
    @Override
    public Facture FactureRequestDTOToFacture(FactureRequestDTO factureRequestDTO) {
        return null;
    }

}
