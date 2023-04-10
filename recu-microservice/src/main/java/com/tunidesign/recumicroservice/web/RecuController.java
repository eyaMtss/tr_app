package com.tunidesign.recumicroservice.web;
import com.tunidesign.recumicroservice.exceptions.RecuIntrouvableException;
import com.tunidesign.recumicroservice.model.Recu;
import com.tunidesign.recumicroservice.repository.RecuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recu")
public class RecuController {
    @Autowired
    private RecuRepository recuRepository;
    @GetMapping("/getAll")
    public List<Recu > listeRecus()
    {
        return recuRepository.findAll();
    }

    @GetMapping(value = "/getById/{id}")
    public Recu afficherUnRecu(@PathVariable Long id) {
        return  recuRepository.findById(id).get();
        //if(service==null) throw new RecuIntrouvableException("Le service avec l'id " + id + " est INTROUVABLE. ");
       // return service;
    }

    @PostMapping(value = "/add")
    public void ajouterUnrecu(@RequestBody Recu recu)
    {
        recuRepository.save(recu);
    }
    @DeleteMapping (value = "/delete/{id}")
    public void supprimerUnRecu(@PathVariable Long id)
    {
        recuRepository.deleteById(id);
        // if(facture==null) throw new RecuIntrouvableException("La facture avec l'id " + id + " est INTROUVABLE. ");

    }
    @PutMapping (value = "/update")
    public void modiferUnRecu(@RequestBody Recu recu)
    {
           recuRepository.save(recu);
        if(recu==null) throw new RecuIntrouvableException("Cette facture est INTROUVABLE. ");

    }
}
