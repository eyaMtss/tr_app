package com.tunidesign.assurancemicroservice.web;

import com.tunidesign.assurancemicroservice.DTO.AssuranceResponseDTO;
import com.tunidesign.assurancemicroservice.exceptions.AssuranceIntrouvableException;
import com.tunidesign.assurancemicroservice.model.Assurance;
import com.tunidesign.assurancemicroservice.repository.AssuranceRepository;
import com.tunidesign.assurancemicroservice.service.AssuranceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/assurance")
public class AssuranceController {
    @Autowired
    private AssuranceRepository assuranceRepository;
    @Autowired
    private AssuranceServiceImpl assuranceService;
    @GetMapping("/getAll")
    public ResponseEntity<List<AssuranceResponseDTO>> getInsurances() {
        return ResponseEntity.ok().body(assuranceService.getInsurances());
    }

    @GetMapping(value = "/getById/{id}")
    public Assurance afficherUnAssurance(@PathVariable Long id) {
        Assurance assurance = assuranceRepository.findById(id).get();
        if(assurance==null) throw new AssuranceIntrouvableException("L'Assurance' avec l'id " + id + " est INTROUVABLE. ");
        return assurance;
    }

    @PostMapping(value = "/add")
    public void passerUnAssurance(@RequestBody Assurance assurance)
    {
        assuranceRepository.save(assurance);
    }
    @DeleteMapping (value = "/delete/{id}")
    public void supprimerUnAssurance(@PathVariable Long id)
    {
        assuranceRepository.deleteById(id);

    }
    @PutMapping (value = "/update")
    public void modiferUnAssurance(@RequestBody Assurance assurance)
    {
        assuranceRepository.save(assurance);
        if(assurance==null) throw new AssuranceIntrouvableException("Cette assurance est INTROUVABLE. ");

    }
}
