package com.tunidesign.societeRemorquagemicroservice.web;


import com.tunidesign.societeRemorquagemicroservice.DTO.SocieteRemorquageRequestDTO;
import com.tunidesign.societeRemorquagemicroservice.DTO.SocieteRemorquageResponseDTO;
import com.tunidesign.societeRemorquagemicroservice.exceptions.SocieteIntrouvableException;
import com.tunidesign.societeRemorquagemicroservice.service.SocieteRemorquageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SocieteRemorquageController {
    @Autowired
    private SocieteRemorquageService societeRemorquageService;

    @GetMapping("/test")
    public String test() {
        return "ça marche";
    }
    @GetMapping("/societes")
    public List<SocieteRemorquageResponseDTO> listeSocietes() {
        return societeRemorquageService.getSocietes();
    }

    @GetMapping(value = "/societes/{id}")
    public SocieteRemorquageResponseDTO afficherUneSociete(@PathVariable int id) throws SocieteIntrouvableException {
        SocieteRemorquageResponseDTO societe = societeRemorquageService.getSocieteById(id);
        if(societe==null) throw new SocieteIntrouvableException("La societe avec l'id " + id + " est INTROUVABLE. ");
        return societe;
    }
    @PostMapping(value = "/SaveSociete")
    public void saveSociete(@RequestBody SocieteRemorquageRequestDTO societeRemorquageRequestDTO) {
        societeRemorquageService.save(societeRemorquageRequestDTO);
    }
    @DeleteMapping (value = "/DeleteSociete/{id}")
    public void supprimerUneSociete(@PathVariable int id)
    {
        societeRemorquageService.deleteSociete(id);

    }
    @PutMapping (value = "/ModifierUneSociete")
    public SocieteRemorquageResponseDTO modiferUneSociete(@RequestBody SocieteRemorquageRequestDTO societeRemorquageRequestDTO) throws SocieteIntrouvableException {
        SocieteRemorquageResponseDTO garage = societeRemorquageService.save(societeRemorquageRequestDTO);
        if(garage==null) throw new SocieteIntrouvableException("Cette societe est INTROUVABLE. ");
        return garage;
    }
}
