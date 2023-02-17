package com.tunidesign.contratmicroservice.web;

import com.tunidesign.contratmicroservice.model.Contrat;
import com.tunidesign.contratmicroservice.exceptions.ContratIntrouvableException;
import com.tunidesign.contratmicroservice.repository.ContratRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ContratController {
    @Autowired
    private ContratRepository contratRepository;
    @GetMapping("/Contrats")
    public List<Contrat> listeContrats()
    {
        return contratRepository.findAll();
    }

    @GetMapping(value = "/Contrats/{id}")
    public Contrat afficherUneContrat(@PathVariable int id) {
        Contrat contrat = contratRepository.findById(id);
        //if(contrat==null) throw new ContratIntrouvableException("Le contrat' avec l'id " + id + "n'existe pas  ");
        return contrat;
    }

    @PostMapping(value = "/Contrat/CréeUnContrat")
    public void ajouterUnContrat(@RequestBody Contrat contrat)
    {
        contratRepository.save(contrat);
    }
    @DeleteMapping (value = "/Contrats/SupprimerContrat/{id}")
    public void supprimerUnContrat(@PathVariable int id)
    {
        Contrat contrat = contratRepository.deleteById(id);
        //if(contrat==null) throw new ContratIntrouvableException("Le contrat avec l'id " + id + " est INTROUVABLE. ");
    }
    @PutMapping (value = "/Contrat/ModifierUnContrat")
    public void modiferUnContrat (@RequestBody Contrat contrat)
    {
        contratRepository.save(contrat);
        if(contrat==null) throw new ContratIntrouvableException("Ce contrat n'existe pas . ");
    }
}
