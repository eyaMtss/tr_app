package com.tunidesign.garagemicroservice.web;


import com.tunidesign.garagemicroservice.dto.GarageRequestDto;
import com.tunidesign.garagemicroservice.dto.GarageResponseDto;
import com.tunidesign.garagemicroservice.exceptions.GarageIntrouvableException;
import com.tunidesign.garagemicroservice.service.GarageService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/garage")
public class GarageController {
    @Autowired
    private GarageService garageService;

    @GetMapping("/getAll")
    public List<GarageResponseDto> listeGarages() {
        return garageService.getGarages();
    }

    @GetMapping(value = "/getById/{id}")
    public GarageResponseDto afficherUnGarage(@PathVariable Long id) throws GarageIntrouvableException {
        GarageResponseDto garage = garageService.getGarageById(id);
        if(garage==null) throw new GarageIntrouvableException("Le garage avec l'id " + id + " est INTROUVABLE. ");
        return garage;
    }
    @PostMapping(value = "/add")
    public void passerUnOrder(@RequestBody GarageRequestDto garageRequestDTO) {
        garageService.save(garageRequestDTO);
    }
    @DeleteMapping (value = "/delete/{id}")
    public void supprimerUnGarage(@PathVariable Long id) {
        garageService.deleteGarage(id);
    }
    @PutMapping (value = "/update")
    public GarageResponseDto modiferUnGarage(@RequestBody GarageRequestDto orderRequestDTO) throws GarageIntrouvableException {
        GarageResponseDto garage = garageService.save(orderRequestDTO);
        if(garage==null) throw new GarageIntrouvableException("Cet ordre est INTROUVABLE. ");
        return garage;
    }

    @PostMapping("/addAll/{userId}")
    public ResponseEntity<List<GarageResponseDto>> addAll(@PathVariable Long userId, @Valid @RequestBody List<GarageRequestDto> garagesRequestDTO) throws Exception {

            List<GarageResponseDto> savedGarages = garageService.addAll(userId, garagesRequestDTO);
            return new ResponseEntity<>(savedGarages, HttpStatus.CREATED);

    }
}
