package com.tunidesign.facturemicroservice.web;

import com.tunidesign.facturemicroservice.exceptions.FactureIntrouvableException;
import com.tunidesign.facturemicroservice.model.Facture;
import com.tunidesign.facturemicroservice.repository.FactureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/facture")
public class FactureController {
    @Autowired
    private FactureRepository factureRepository;
    @GetMapping("/getAll")
    public List<Facture> listeFactures()
    {
        return factureRepository.findAll();
    }

    @GetMapping(value = "/getById/{id}")
    public Facture afficherUneFacture(@PathVariable int id) {
        Facture facture = factureRepository.findById(id);
        if(facture==null) throw new FactureIntrouvableException("La facture avec l'id " + id + " est INTROUVABLE. ");
        return facture;
    }

    @PostMapping(value = "/add")
    public void ajouterUneFacture(@RequestBody Facture facture)
    {
        factureRepository.save(facture);
    }
    @DeleteMapping (value = "/delete/{id}")
    public void supprimerUnefacture(@PathVariable int id)
    {
        Facture facture = factureRepository.deleteById(id);
        if(facture==null) throw new FactureIntrouvableException("La facture avec l'id " + id + " est INTROUVABLE. ");

    }
    @PutMapping (value = "/update")
    public void modiferUneFacture (@RequestBody Facture facture)
    {
        factureRepository.save(facture);
        if(facture==null) throw new FactureIntrouvableException("Cette facture est INTROUVABLE. ");

    }
}
