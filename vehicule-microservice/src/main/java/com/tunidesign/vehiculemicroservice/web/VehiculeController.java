package com.tunidesign.vehiculemicroservice.web;

import com.tunidesign.vehiculemicroservice.exceptions.VehiculeIntrouvableException;
import com.tunidesign.vehiculemicroservice.model.entity.Vehicule;
import com.tunidesign.vehiculemicroservice.repository.VehiculeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VehiculeController {
    @Autowired
    private VehiculeRepository vehiculeRepository;
    @GetMapping("/Vehicules")
    public List<Vehicule> listeVehicules()
    {
        return vehiculeRepository.findAll();
    }

    @GetMapping(value = "/Vehicules/{id}")
    public Vehicule afficherUnVehicule(@PathVariable int id) {
        Vehicule vehicule = vehiculeRepository.findById(id);
        if(vehicule==null) throw new VehiculeIntrouvableException("La Vehicule avec l'id " + id + " est INTROUVABLE. ");
        return vehicule;
    }

    @PostMapping(value = "/PasserUnVehicule")
    public void passerUnVehicule(@RequestBody Vehicule vehicule)
    {
        vehiculeRepository.save(vehicule);
    }
    @DeleteMapping (value = "/AnnulerUnVehicule/{id}")
    public void supprimerUnVehicule(@PathVariable int id)
    {
        Vehicule vehicule = vehiculeRepository.deleteById(id);
        if(vehicule==null) throw new VehiculeIntrouvableException("La Vehicule avec l'id " + id + " est INTROUVABLE. ");

    }
    @PutMapping (value = "/ModifierUnVehicule")
    public void modiferUnVehicule(@RequestBody Vehicule vehicule)
    {
        vehiculeRepository.save(vehicule);
        if(vehicule==null) throw new VehiculeIntrouvableException("Cette Vehicule est INTROUVABLE. ");

    }
}
