package com.tunidesign.vehiculemicroservice.web;

import com.tunidesign.vehiculemicroservice.DTO.VehiculeRequestDTO;
import com.tunidesign.vehiculemicroservice.DTO.VehiculeResponseDTO;
import com.tunidesign.vehiculemicroservice.exceptions.VehiculeIntrouvableException;
import com.tunidesign.vehiculemicroservice.model.entity.Vehicule;
import com.tunidesign.vehiculemicroservice.service.VehiculeServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicule")
public class VehiculeController {
    @Autowired
    private VehiculeServiceImpl vehiculeService;
    @GetMapping("/getAll")
    public ResponseEntity<List<VehiculeResponseDTO>> listeVehicules()
    {
        List<VehiculeResponseDTO> users = vehiculeService.getVehicles();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<VehiculeResponseDTO> afficherUneVehicule(@PathVariable Long id) {
        VehiculeResponseDTO vehicule = vehiculeService.getVehicle(id);
        if(vehicule==null) throw new VehiculeIntrouvableException("La Vehicule avec l'id " + id + " est INTROUVABLE. ");
        return ResponseEntity.ok().body(vehicule);
    }

    @PostMapping("/add")
    public ResponseEntity<VehiculeResponseDTO> ajouterUneVehicule(@RequestBody VehiculeRequestDTO vehiculeRequestDTO)
    {
        try {
            VehiculeResponseDTO savedVehicle = vehiculeService.save(vehiculeRequestDTO);
            return new ResponseEntity<>(savedVehicle, HttpStatus.CREATED);
        } catch (Exception e) {
            throw new VehiculeIntrouvableException(e.getMessage());
        }
    }

    @DeleteMapping("/Delete/{id}")
    public ResponseEntity<?> supprimerUneVehicule(@PathVariable Long id)
    {
        try {
            vehiculeService.deleteVehicle(id);
            return ResponseEntity.noContent().build();
        } catch (Exception ex) {
            throw new VehiculeIntrouvableException("Vehicle doesn't exist");
        }
    }

    @PutMapping ("/update")
    public ResponseEntity<VehiculeResponseDTO> modiferUneVehicule(@RequestBody VehiculeRequestDTO vehiculeRequestDTO)
    {
        VehiculeResponseDTO vehicule = vehiculeService.save(vehiculeRequestDTO);
        if(vehicule==null) throw new VehiculeIntrouvableException("Cette véhicule est INTROUVABLE. ");
        return new ResponseEntity<>(vehicule, HttpStatus.OK);
    }
}