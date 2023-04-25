package com.tunidesign.facturemicroservice.web;

import com.tunidesign.facturemicroservice.dto.FactureRequestDto;
import com.tunidesign.facturemicroservice.dto.FactureResponseDto;
import com.tunidesign.facturemicroservice.exceptions.FactureIntrouvableException;
import com.tunidesign.facturemicroservice.service.FactureServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/facture")
public class FactureController {
    @Autowired
    private FactureServiceImpl factureService;
    @GetMapping("/getAll")
    public List<FactureResponseDto> listeFactures() {
        return factureService.getFactures();
    }

    @GetMapping(value = "/getById/{id}")
    public FactureResponseDto afficherUneFacture(@PathVariable Long id) {
        FactureResponseDto facture = factureService.getFacture(id);
        if(facture==null) throw new FactureIntrouvableException("La facture avec l'id " + id + " est INTROUVABLE. ");
        return facture;
    }

    @PostMapping(value = "/add")
    public FactureResponseDto ajouterUneFacture(@RequestBody FactureRequestDto facture) {
        return factureService.save(facture);
    }
    @DeleteMapping (value = "/delete/{id}")
    public void supprimerUnefacture(@PathVariable Long id) {
        factureService.deleteFacture(id);
    }
    @PutMapping (value = "/update")
    public FactureResponseDto modiferUneFacture (@RequestBody FactureRequestDto facture) {
        FactureResponseDto updatedFacture = factureService.update(facture);
        if(updatedFacture==null) throw new FactureIntrouvableException("Cette facture est INTROUVABLE. ");
        else return updatedFacture;
    }
}
