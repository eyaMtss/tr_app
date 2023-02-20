package com.tunidesign.recumicroservice.web;
import com.tunidesign.recumicroservice.exceptions.RecuIntrouvableException;
import com.tunidesign.recumicroservice.model.Recu;
import com.tunidesign.recumicroservice.repository.RecuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class RecuController {
    @Autowired
    private RecuRepository recuRepository;
    @GetMapping("/Recus")
    public List<Recu > listeRecus()
    {
        return recuRepository.findAll();
    }

    @GetMapping(value = "/Recus/{id}")
    public Recu afficherUnRecu(@PathVariable int id) {
        return  recuRepository.findById(id);
        //if(service==null) throw new RecuIntrouvableException("Le service avec l'id " + id + " est INTROUVABLE. ");
       // return service;
    }

    @PostMapping(value = "/Recus/AjouterUnRecu")
    public void ajouterUnrecu(@RequestBody Recu recu)
    {
        recuRepository.save(recu);
    }
    @DeleteMapping (value = "/Recus/SupprimerUnRecu/{id}")
    public void supprimerUnRecu(@PathVariable int id)
    {
        recuRepository.deleteById(id);
        // if(facture==null) throw new RecuIntrouvableException("La facture avec l'id " + id + " est INTROUVABLE. ");

    }
    @PutMapping (value = "/Recu/ModifierUnRecu")
    public void modiferUnRecu(@RequestBody Recu recu)
    {
           recuRepository.save(recu);
        if(recu==null) throw new RecuIntrouvableException("Cette facture est INTROUVABLE. ");

    }
}
