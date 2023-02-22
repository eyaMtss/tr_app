package com.example.agencemicroservice.web;

import com.example.agencemicroservice.exceptions.AgenceIntrouvableException;
import com.example.agencemicroservice.model.Agence;
import com.example.agencemicroservice.repository.AgenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AgenceController {
    @Autowired
    private AgenceRepository agenceRepository;
    @GetMapping("/Agences")
    public List<Agence> listeAgences()
    {
        return agenceRepository.findAll();
    }

    @GetMapping(value = "/Agences/{id}")
    public Agence afficherUneAgence(@PathVariable int id) {
        Agence agence = agenceRepository.findById(id);
        if(agence==null) throw new AgenceIntrouvableException("L'agence' avec l'id " + id + " est INTROUVABLE. ");
        return agence;
    }

    @PostMapping(value = "/Agences/AjouterUneAgence")
    public void ajouterUneAgence(@RequestBody Agence agence)
    {
        agenceRepository.save(agence);
    }
    @DeleteMapping (value = "/Agences/SupprimerUneAgence/{id}")
    public void supprimerUneAgence(@PathVariable int id)
    {
        Agence agence = agenceRepository.deleteById(id);
        if(agence==null) throw new AgenceIntrouvableException("L'agence avec l'id " + id + " est INTROUVABLE. ");

    }
    @PutMapping (value = "/Agences/ModifierUneAgence")
    public void modiferUneAgence (@RequestBody Agence agence)
    {
        agenceRepository.save(agence);
        if(agence==null) throw new AgenceIntrouvableException("Cette agence est INTROUVABLE. ");

    }
}
