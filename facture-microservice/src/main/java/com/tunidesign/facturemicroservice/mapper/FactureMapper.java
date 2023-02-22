package com.tunidesign.facturemicroservice.mapper;

import com.tunidesign.facturemicroservice.DTO.FactureRequestDTO;
import com.tunidesign.facturemicroservice.DTO.FactureResponseDTO;
import com.tunidesign.facturemicroservice.model.Facture;

public interface FactureMapper {
    FactureResponseDTO factureToFactureDTO(Facture facture);
    Facture FactureRequestDTOToFacture(FactureRequestDTO factureRequestDTO);
}
