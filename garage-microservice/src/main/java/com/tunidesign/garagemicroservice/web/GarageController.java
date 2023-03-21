package com.tunidesign.garagemicroservice.web;


import com.tunidesign.garagemicroservice.DTO.GarageRequestDTO;
import com.tunidesign.garagemicroservice.DTO.GarageResponseDTO;
import com.tunidesign.garagemicroservice.exceptions.GarageIntrouvableException;
import com.tunidesign.garagemicroservice.service.GarageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GarageController {
    @Autowired
    private GarageService garageService;

    @GetMapping("/test")
    public String test() {
        return "ça marche";
    }
    @GetMapping("/garages")
    public List<GarageResponseDTO> listeGarages() {
        return garageService.getGarages();
    }

    @GetMapping(value = "/garages/{id}")
    public GarageResponseDTO afficherUnGarage(@PathVariable int id) throws GarageIntrouvableException {
        GarageResponseDTO garage = garageService.getGarageById(id);
        if(garage==null) throw new GarageIntrouvableException("Le garage avec l'id " + id + " est INTROUVABLE. ");
        return garage;
    }
    @PostMapping(value = "/SaveGarage")
    public void passerUnOrder(@RequestBody GarageRequestDTO garageRequestDTO) {
        garageService.save(garageRequestDTO);
    }
    @DeleteMapping (value = "/DeleteGarage/{id}")
    public void supprimerUnGarage(@PathVariable int id)
    {
        garageService.deleteGarage(id);
      //  if(order==null) throw new OrderIntrouvableException("L'ordre avec l'id " + id + " est INTROUVABLE. ");
    }
    @PutMapping (value = "/ModifierUnGarage")
    public GarageResponseDTO modiferUnGarage(@RequestBody GarageRequestDTO orderRequestDTO) throws GarageIntrouvableException {
        GarageResponseDTO garage = garageService.save(orderRequestDTO);
        if(garage==null) throw new GarageIntrouvableException("Cet ordre est INTROUVABLE. ");
        return garage;
    }
}
