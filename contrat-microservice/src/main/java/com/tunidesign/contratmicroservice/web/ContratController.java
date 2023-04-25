package com.tunidesign.contratmicroservice.web;

import com.tunidesign.contratmicroservice.dto.ContratRequestDto;
import com.tunidesign.contratmicroservice.dto.ContratResponseDto;
import com.tunidesign.contratmicroservice.dto.VerifyContractRequestDto;
import com.tunidesign.contratmicroservice.dto.VerifyContractResponseDto;
import com.tunidesign.contratmicroservice.model.Contrat;
import com.tunidesign.contratmicroservice.exceptions.ContratIntrouvableException;
import com.tunidesign.contratmicroservice.repository.ContratRepository;
import com.tunidesign.contratmicroservice.service.ContratServiceImpl;
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
    public ContratResponseDto afficherUneContrat(@PathVariable Long id) {
        return contratService.getContrat(id);
    }

    @PostMapping(value = "/add")
    public ContratResponseDto ajouterUnContrat(@RequestBody ContratRequestDto contrat) {
        return contratService.save(contrat);
    }
    @DeleteMapping (value = "/delete/{id}")
    public void supprimerUnContrat(@PathVariable Long id) {
        contratService.deleteContrat(id);
    }
    @PutMapping (value = "/update")
    public ContratResponseDto modiferUnContrat (@RequestBody ContratRequestDto contrat) {
        ContratResponseDto savedContract = contratService.save(contrat);
        if(savedContract.equals(null)) throw new ContratIntrouvableException("Ce contrat n'existe pas . ");
        else return savedContract;
    }
    @PostMapping("/verifyContrat")
    public ResponseEntity<VerifyContractResponseDto> verifyContract(@RequestBody VerifyContractRequestDto verifyContractRequestDTO){
        return new ResponseEntity<>(VerifyContractResponseDto.builder()
                .isExist(contratService.verifyContract(verifyContractRequestDTO))
                .build(), HttpStatus.OK) ;
    }
}
