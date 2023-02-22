package com.tunidesign.servicemicroservice.web;
import com.tunidesign.servicemicroservice.model.Service;
import com.tunidesign.servicemicroservice.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin
public class ServiceController {
    @Autowired
    private ServiceRepository serviceRepository;
    @GetMapping("/Services")
    public List<Service > listeServices()
    {
        return serviceRepository.findAll();
    }

    @GetMapping(value = "/Services/{id}")
    public Service afficherUnService(@PathVariable int id) {
        return  serviceRepository.findById(id);
        //if(service==null) throw new ServiceIntrouvableException("Le service avec l'id " + id + " est INTROUVABLE. ");
       // return service;
    }

    @PostMapping(value = "/Services/AjouterUnService")
    public void ajouterUnservice(@RequestBody Service service)
    {
        serviceRepository.save(service);
    }
    @DeleteMapping (value = "/Services/SupprimerUnService/{id}")
    public void supprimerUnService(@PathVariable int id)
    {
        serviceRepository.deleteById(id);
        // if(facture==null) throw new FactureIntrouvableException("La facture avec l'id " + id + " est INTROUVABLE. ");

    }
    @PutMapping (value = "/Services/ModifierUnService")
    public void modiferUnService (@RequestBody Service service)
    {
           serviceRepository.save(service);
       // if(service==null) throw new ServiceIntrouvableException("Cette facture est INTROUVABLE. ");

    }
}
