package com.tunidesign.contratmicroservice.web;

import com.tunidesign.contratmicroservice.DTO.VerifyContractRequestDTO;
import com.tunidesign.contratmicroservice.DTO.VerifyContractResponseDTO;
import com.tunidesign.contratmicroservice.model.Contrat;
import com.tunidesign.contratmicroservice.exceptions.ContratIntrouvableException;
import com.tunidesign.contratmicroservice.repository.ContratRepository;
import com.tunidesign.contratmicroservice.service.ContratServiceImpl;
import jakarta.annotation.security.RolesAllowed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contrat")
public class ContratController {
    @Autowired
    private ContratRepository contratRepository;
    @Autowired
    private ContratServiceImpl contratService;
    @GetMapping("/getAll")
    public List<Contrat> listeContrats()
    {
        return contratRepository.findAll();
    }

    @GetMapping(value = "/getById/{id}")
    public Contrat afficherUneContrat(@PathVariable Long id) {
        Contrat contrat = contratRepository.findById(id).get();
        return contrat;
    }

    @PostMapping(value = "/add")
    public void ajouterUnContrat(@RequestBody Contrat contrat)
    {
        contratRepository.save(contrat);
    }
    @DeleteMapping (value = "/Contrats/SupprimerContrat/{id}")
    public void supprimerUnContrat(@PathVariable Long id)
    {
        contratRepository.deleteById(id);
    }
    @PutMapping (value = "/update")
    public void modiferUnContrat (@RequestBody Contrat contrat)
    {
        contratRepository.save(contrat);
        if(contrat==null) throw new ContratIntrouvableException("Ce contrat n'existe pas . ");
    }
    @PostMapping("/verifyContrat")
    public ResponseEntity<VerifyContractResponseDTO> verifyContract(@RequestBody VerifyContractRequestDTO verifyContractRequestDTO){
        return new ResponseEntity<>(VerifyContractResponseDTO.builder()
                .isExist(contratService.verifyContract(verifyContractRequestDTO))
                .build(), HttpStatus.OK) ;
    }
}
