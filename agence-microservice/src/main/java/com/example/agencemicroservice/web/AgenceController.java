package com.example.agencemicroservice.web;

import com.example.agencemicroservice.dto.AgenceRequestDto;
import com.example.agencemicroservice.dto.AgenceResponseDto;
import com.example.agencemicroservice.exceptions.AgenceIntrouvableException;
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
    public List<AgenceResponseDto> listeAgences() {
        return agenceService.getAgences();
    }

    @GetMapping("/getAllByInsurance/{idAssurance}")
    public List<AgenceResponseDto> listeAgences(@PathVariable Long idAssurance) {
        return agenceService.getByInsurance(idAssurance);
    }

    @GetMapping(value = "/getById/{id}")
    public AgenceResponseDto afficherUneAgence(@PathVariable Long id) {
        AgenceResponseDto agence = agenceService.getAgence(id);
        if(agence==null) throw new AgenceIntrouvableException("L'agence' avec l'id " + id + " est INTROUVABLE. ");
        return agence;
    }

    @PostMapping(value = "/add")
    public AgenceResponseDto ajouterUneAgence(@RequestBody AgenceRequestDto agence) {
        return agenceService.save(agence);
    }
    @DeleteMapping (value = "/delete/{id}")
    public void supprimerUneAgence(@PathVariable Long id) {
        agenceService.deleteAgence(id);

    }
    @PutMapping (value = "/update")
    public AgenceResponseDto modiferUneAgence (@RequestBody AgenceRequestDto agenceRequestDTO)
    {
        AgenceResponseDto agence = agenceService.update(agenceRequestDTO);
        if(agence==null) throw new AgenceIntrouvableException("Cette agence est INTROUVABLE. ");
        else return agence;
    }
}
