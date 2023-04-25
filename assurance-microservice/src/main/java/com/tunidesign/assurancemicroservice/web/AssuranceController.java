package com.tunidesign.assurancemicroservice.web;

import com.tunidesign.assurancemicroservice.dto.AssuranceRequestDto;
import com.tunidesign.assurancemicroservice.dto.AssuranceResponseDto;
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
    public ResponseEntity<List<AssuranceResponseDto>> getInsurances() {
        return ResponseEntity.ok().body(assuranceService.getInsurances());
    }

    @GetMapping(value = "/getById/{id}")
    public Assurance afficherUnAssurance(@PathVariable Long id) {
        Assurance assurance = assuranceRepository.findById(id).get();
        if(assurance==null) throw new AssuranceIntrouvableException("L'Assurance' avec l'id " + id + " est INTROUVABLE. ");
        return assurance;
    }

    @PostMapping(value = "/add")
    public AssuranceResponseDto passerUnAssurance(@RequestBody AssuranceRequestDto assurance) {
        return assuranceService.save(assurance);
    }
    @DeleteMapping (value = "/delete/{id}")
    public void supprimerUnAssurance(@PathVariable Long id) {
        assuranceService.deleteAssurance(id);
    }
    @PutMapping (value = "/update")
    public AssuranceResponseDto modiferUnAssurance(@RequestBody AssuranceRequestDto assurance) {
        AssuranceResponseDto updatedInsurance = assuranceService.update(assurance);
        if(updatedInsurance==null) throw new AssuranceIntrouvableException("Cette assurance est INTROUVABLE. ");
        else return updatedInsurance;
    }
}
