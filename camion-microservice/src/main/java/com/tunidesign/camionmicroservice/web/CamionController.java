package com.tunidesign.camionmicroservice.web;

import com.tunidesign.camionmicroservice.exceptions.CamionIntrouvableException;
import com.tunidesign.camionmicroservice.model.Camion;
import com.tunidesign.camionmicroservice.repository.CamionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/camion")
public class CamionController {
    @Autowired
    private CamionRepository camionRepository;
    @GetMapping("/getAll")
    public List<Camion> listeCamions()
    {
        return camionRepository.findAll();
    }

    @GetMapping(value = "/getById/{id}")
    public Camion afficherUnCamion(@PathVariable int id) {
        Camion camion = camionRepository.findById(id);
        if(camion==null) throw new CamionIntrouvableException("Le camion avec l'id " + id + " est INTROUVABLE. ");
        return camion;
    }

    @PostMapping(value = "/add")
    public void passerUnCamion(@RequestBody Camion camion)
    {
        camionRepository.save(camion);
    }
    @DeleteMapping (value = "/delete/{id}")
    public void supprimerUnCamion(@PathVariable int id)
    {
         camionRepository.deleteById(id);
    }
    @PutMapping (value = "/update")
    public void modiferUnCamion(@RequestBody Camion camion)
    {
    	camionRepository.save(camion);
        if(camion==null) throw new CamionIntrouvableException("Ce camion  est INTROUVABLE. ");

    }
}
// methode affecter un camion a un client ?????????
