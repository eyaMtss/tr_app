package com.tunidesign.societeRemorquagemicroservice.web;


import com.tunidesign.societeRemorquagemicroservice.DTO.SocieteRemorquageRequestDTO;
import com.tunidesign.societeRemorquagemicroservice.DTO.SocieteRemorquageResponseDTO;
import com.tunidesign.societeRemorquagemicroservice.exceptions.SocieteIntrouvableException;
import com.tunidesign.societeRemorquagemicroservice.service.SocieteRemorquageService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/societeRemorquage")
public class SocieteRemorquageController {
    @Autowired
    private SocieteRemorquageService societeRemorquageService;

    @GetMapping("/getAll")
    public ResponseEntity<List<SocieteRemorquageResponseDTO>> listeSocietes() {
        List<SocieteRemorquageResponseDTO> users = societeRemorquageService.getSocietes();
        return ResponseEntity.ok(users);
    }
    @GetMapping(value = "/getById/{id}")
    public ResponseEntity<SocieteRemorquageResponseDTO> afficherUneSociete(@PathVariable Long id) {
        return ResponseEntity.ok().body(societeRemorquageService.getSocieteById(id));
    }
    @PostMapping(path = "/add")
    public ResponseEntity<SocieteRemorquageResponseDTO> saveSociete(@Valid @RequestBody SocieteRemorquageRequestDTO societeRemorquageRequestDTO) throws SocieteIntrouvableException {
        try {
            SocieteRemorquageResponseDTO savedSociete = societeRemorquageService.save(societeRemorquageRequestDTO);
            return new ResponseEntity<>(savedSociete, HttpStatus.CREATED);
        } catch (Exception e) {
            throw new SocieteIntrouvableException(e.getMessage());
        }
    }
    @DeleteMapping (value = "/Delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) throws SocieteIntrouvableException {
        try {
            societeRemorquageService.deleteSociete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception ex) {
            throw new SocieteIntrouvableException("Societe doesn't exist");
        }
    }
    @PutMapping (value = "/update")
    public SocieteRemorquageResponseDTO modiferUneSociete(@RequestBody SocieteRemorquageRequestDTO societeRemorquageRequestDTO) throws SocieteIntrouvableException {
        SocieteRemorquageResponseDTO garage = societeRemorquageService.save(societeRemorquageRequestDTO);
        if(garage==null) throw new SocieteIntrouvableException("Cette societe est INTROUVABLE. ");
        return garage;
    }
}
