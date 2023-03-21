package com.tunidesign.assurancemicroservice.web;

import com.tunidesign.assurancemicroservice.exceptions.AssuranceIntrouvableException;
import com.tunidesign.assurancemicroservice.model.Assurance;
import com.tunidesign.assurancemicroservice.repository.AssuranceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AssuranceController {
    @Autowired
    private AssuranceRepository assuranceRepository;
    @GetMapping("/Assurances")
    public List<Assurance> listeAssurances()
    {
        return assuranceRepository.findAll();
    }

    @GetMapping(value = "/Assurances/{id}")
    public Assurance afficherUnAssurance(@PathVariable int id) {
        Assurance assurance = assuranceRepository.findById(id);
        if(assurance==null) throw new AssuranceIntrouvableException("L'Assurance' avec l'id " + id + " est INTROUVABLE. ");
        return assurance;
    }

    @PostMapping(value = "/PasserUneAssurance")
    public void passerUnAssurance(@RequestBody Assurance assurance)
    {
        assuranceRepository.save(assurance);
    }
    @DeleteMapping (value = "/AnnulerUnAssurance/{id}")
    public void supprimerUnAssurance(@PathVariable int id)
    {
        Assurance assurance = assuranceRepository.deleteById(id);
        if(assurance==null) throw new AssuranceIntrouvableException("L'Assuranceavec l'id " + id + " est INTROUVABLE. ");

    }
    @PutMapping (value = "/ModifierUneAssurance")
    public void modiferUnAssurance(@RequestBody Assurance assurance)
    {
        assuranceRepository.save(assurance);
        if(assurance==null) throw new AssuranceIntrouvableException("Cette assurance est INTROUVABLE. ");

    }
}
