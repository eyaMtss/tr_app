package com.tunidesign.facturemicroservice.web;

import com.tunidesign.facturemicroservice.exceptions.FactureIntrouvableException;
import com.tunidesign.facturemicroservice.model.Facture;
import com.tunidesign.facturemicroservice.repository.FactureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Re
public class FactureController {
    @Autowired
    private FactureRepository factureRepository;
    @GetMapping("/Factures")
    public List<Facture> listeFactures()
    {
        return factureRepository.findAll();
    }

    @GetMapping(value = "/Factures/{id}")
    public Facture afficherUneFacture(@PathVariable int id) {
        Facture facture = factureRepository.findById(id);
        if(facture==null) throw new FactureIntrouvableException("La facture avec l'id " + id + " est INTROUVABLE. ");
        return facture;
    }

    @PostMapping(value = "/Factures/AjouterUneFcature")
    public void ajouterUneFacture(@RequestBody Facture facture)
    {
        factureRepository.save(facture);
    }
    @DeleteMapping (value = "/Factures/SupprimerUnefacture/{id}")
    public void supprimerUnefacture(@PathVariable int id)
    {
        Facture facture = factureRepository.deleteById(id);
        if(facture==null) throw new FactureIntrouvableException("La facture avec l'id " + id + " est INTROUVABLE. ");

    }
    @PutMapping (value = "/Factures/ModifierUneFacture")
    public void modiferUneFacture (@RequestBody Facture facture)
    {
        factureRepository.save(facture);
        if(facture==null) throw new FactureIntrouvableException("Cette facture est INTROUVABLE. ");

    }
}
