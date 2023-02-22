package com.tunidesign.facturemicroservice.service;



import com.tunidesign.facturemicroservice.DTO.FactureRequestDTO;
import com.tunidesign.facturemicroservice.DTO.FactureResponseDTO;

import java.util.List;

public interface FactureService {

        List<FactureResponseDTO> getFacture();
        FactureResponseDTO getFacture(String id);
        FactureResponseDTO save(FactureRequestDTO factureRequestDTO);
        void deleteFacture( String id);
        FactureResponseDTO update(FactureRequestDTO factureRequestDTO);
        List <FactureResponseDTO> getFactureByPostId(String id);
}
