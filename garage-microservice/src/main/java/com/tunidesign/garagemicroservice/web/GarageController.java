package com.tunidesign.garagemicroservice.web;


import com.tunidesign.garagemicroservice.DTO.GarageRequestDTO;
import com.tunidesign.garagemicroservice.DTO.GarageResponseDTO;
import com.tunidesign.garagemicroservice.exceptions.GarageIntrouvableException;
import com.tunidesign.garagemicroservice.service.GarageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/garage")
public class GarageController {
    @Autowired
    private GarageService garageService;

    @GetMapping("/test")
    public String test() {
        return "ça marche";
    }
    @GetMapping("/getAll")
    public List<GarageResponseDTO> listeGarages() {
        return garageService.getGarages();
    }

    @GetMapping(value = "/getById/{id}")
    public GarageResponseDTO afficherUnGarage(@PathVariable Long id) throws GarageIntrouvableException {
        GarageResponseDTO garage = garageService.getGarageById(id);
        if(garage==null) throw new GarageIntrouvableException("Le garage avec l'id " + id + " est INTROUVABLE. ");
        return garage;
    }
    @PostMapping(value = "/add")
    public void passerUnOrder(@RequestBody GarageRequestDTO garageRequestDTO) {
        garageService.save(garageRequestDTO);
    }
    @DeleteMapping (value = "/delete/{id}")
    public void supprimerUnGarage(@PathVariable Long id)
    {
        garageService.deleteGarage(id);
      //  if(order==null) throw new OrderIntrouvableException("L'ordre avec l'id " + id + " est INTROUVABLE. ");
    }
    @PutMapping (value = "/update")
    public GarageResponseDTO modiferUnGarage(@RequestBody GarageRequestDTO orderRequestDTO) throws GarageIntrouvableException {
        GarageResponseDTO garage = garageService.save(orderRequestDTO);
        if(garage==null) throw new GarageIntrouvableException("Cet ordre est INTROUVABLE. ");
        return garage;
    }
}
