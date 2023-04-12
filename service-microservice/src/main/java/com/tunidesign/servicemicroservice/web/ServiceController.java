package com.tunidesign.servicemicroservice.web;
import com.tunidesign.servicemicroservice.model.Service;
import com.tunidesign.servicemicroservice.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/service")
public class ServiceController {
    @Autowired
    private ServiceRepository serviceRepository;
    @GetMapping("/getAll")
    public List<Service > listeServices()
    {
        return serviceRepository.findAll();
    }

    @GetMapping(value = "/getById/{id}")
    public Service afficherUnService(@PathVariable Long id) {
        return  serviceRepository.findById(id).get();
        //if(service==null) throw new ServiceIntrouvableException("Le service avec l'id " + id + " est INTROUVABLE. ");
       // return service;
    }

    @PostMapping(value = "/add")
    public void ajouterUnservice(@RequestBody Service service)
    {
        serviceRepository.save(service);
    }
    @DeleteMapping (value = "/delete/{id}")
    public void supprimerUnService(@PathVariable Long id)
    {
        serviceRepository.deleteById(id);
        // if(facture==null) throw new FactureIntrouvableException("La facture avec l'id " + id + " est INTROUVABLE. ");

    }
    @PutMapping (value = "/update")
    public void modiferUnService (@RequestBody Service service)
    {
           serviceRepository.save(service);
       // if(service==null) throw new ServiceIntrouvableException("Cette facture est INTROUVABLE. ");

    }
}
