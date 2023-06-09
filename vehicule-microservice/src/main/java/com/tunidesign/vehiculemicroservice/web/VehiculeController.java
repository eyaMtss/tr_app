package com.tunidesign.vehiculemicroservice.web;

import com.tunidesign.vehiculemicroservice.DTO.ContratRequestDTO;
import com.tunidesign.vehiculemicroservice.DTO.ContratResponseDTO;
import com.tunidesign.vehiculemicroservice.DTO.VehiculeRequestDTO;
import com.tunidesign.vehiculemicroservice.DTO.VehiculeResponseDTO;
import com.tunidesign.vehiculemicroservice.exceptions.ContractNotFoundException;
import com.tunidesign.vehiculemicroservice.exceptions.VehiculeIntrouvableException;
import com.tunidesign.vehiculemicroservice.service.VehiculeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/vehicule")
public class VehiculeController {
    @Autowired
    private VehiculeServiceImpl vehiculeService;
    @Autowired
    private RestTemplate restTemplate;
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

    /**
     * Eya Mattoussi
     * 05/04/2023
     * verify the informations provided by the user && add new vehicle
     * @param vehiculeRequestDTO
     * @return boolean
     */
    @PostMapping("/add")
    public ResponseEntity<VehiculeResponseDTO> ajouterUnVehicule(@RequestBody VehiculeRequestDTO vehiculeRequestDTO)
    {
        ContratResponseDTO contratResponseDTO = verifyContract(ContratRequestDTO.builder()
                .numContrat(vehiculeRequestDTO.getNumContrat())
                .numChassis(vehiculeRequestDTO.getNumChassis())
                //.idAssurance(vehiculeRequestDTO.getIdAssurance())
                //.idAgence(vehiculeRequestDTO.getIdAgence())
                //.dateDebut(vehiculeRequestDTO.getDateDebut())
                //.dateFin(vehiculeRequestDTO.getDateFin())
                //.cin(vehiculeRequestDTO.getCin())
                .build()).getBody();
        if (contratResponseDTO.getIsExist()){
            VehiculeResponseDTO savedVehicle = vehiculeService.save(vehiculeRequestDTO);
            return new ResponseEntity<>(savedVehicle, HttpStatus.CREATED);
        }
        else {
            throw new ContractNotFoundException("You don't have a contract");
        }
    }
    @PostMapping("/addAll")
    public ResponseEntity<List<VehiculeResponseDTO>> addVehicles(@RequestBody List<VehiculeRequestDTO> vehiculesRequestDTO)
    {
        List<VehiculeResponseDTO> savedVehicles = new ArrayList<>();
        for(VehiculeRequestDTO vehiculeRequestDTO: vehiculesRequestDTO){
            ContratResponseDTO contratResponseDTO = verifyContract(ContratRequestDTO.builder()
                    .numContrat(vehiculeRequestDTO.getNumContrat())
                    .numChassis(vehiculeRequestDTO.getNumChassis())
                    //.idAssurance(vehiculeRequestDTO.getIdAssurance())
                    //.idAgence(vehiculeRequestDTO.getIdAgence())
                    //.dateDebut(vehiculeRequestDTO.getDateDebut())
                    //.dateFin(vehiculeRequestDTO.getDateFin())
                    //.cin(vehiculeRequestDTO.getCin())
                    .build()).getBody();
            if (contratResponseDTO.getIsExist()){
                VehiculeResponseDTO savedVehicle = vehiculeService.save(vehiculeRequestDTO);
                savedVehicles.add(savedVehicle);
            }
            else {
                throw new ContractNotFoundException("You don't have a contract for this vehicle" + vehiculeRequestDTO.getNumImmat());
            }
        }
        return new ResponseEntity<>(savedVehicles, HttpStatus.CREATED);

    }


    // verify numContrat if exist
    private ResponseEntity<ContratResponseDTO> verifyContract(ContratRequestDTO contratRequestDTO) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> request = new HttpEntity(contratRequestDTO, headers);
        ResponseEntity<ContratResponseDTO> response = restTemplate.postForEntity("http://localhost:8989/contrat/verifyContrat",
                request, ContratResponseDTO.class);
        System.out.println("Response: " + response.getBody());
        return response;
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