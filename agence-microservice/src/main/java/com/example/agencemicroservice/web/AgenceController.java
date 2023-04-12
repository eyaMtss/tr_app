package com.example.agencemicroservice.web;

import com.example.agencemicroservice.DTO.AgenceRequestDTO;
import com.example.agencemicroservice.DTO.AgenceResponseDTO;
import com.example.agencemicroservice.exceptions.AgenceIntrouvableException;
import com.example.agencemicroservice.mapper.AgenceMapperImpl;
import com.example.agencemicroservice.service.AgenceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agence")
public class AgenceController {
    @Autowired
    private AgenceServiceImpl agenceService;
    @GetMapping("/getAll")
    public List<AgenceResponseDTO> listeAgences() {
        return agenceService.getAgences();
    }

    @GetMapping("/getAllByInsurance/{idAssurance}")
    public List<AgenceResponseDTO> listeAgences(@PathVariable Long idAssurance) {
        return agenceService.getByInsurance(idAssurance);
    }

    @GetMapping(value = "/getById/{id}")
    public AgenceResponseDTO afficherUneAgence(@PathVariable Long id) {
        AgenceResponseDTO agence = agenceService.getAgence(id);
        if(agence==null) throw new AgenceIntrouvableException("L'agence' avec l'id " + id + " est INTROUVABLE. ");
        return agence;
    }

    @PostMapping(value = "/add")
    public AgenceResponseDTO ajouterUneAgence(@RequestBody AgenceRequestDTO agence) {
        return agenceService.save(agence);
    }
    @DeleteMapping (value = "/delete/{id}")
    public void supprimerUneAgence(@PathVariable Long id) {
        agenceService.deleteAgence(id);

    }
    @PutMapping (value = "/update")
    public AgenceResponseDTO modiferUneAgence (@RequestBody AgenceRequestDTO agenceRequestDTO)
    {
        AgenceResponseDTO agence = agenceService.update(agenceRequestDTO);
        if(agence==null) throw new AgenceIntrouvableException("Cette agence est INTROUVABLE. ");
        else return agence;
    }
}
