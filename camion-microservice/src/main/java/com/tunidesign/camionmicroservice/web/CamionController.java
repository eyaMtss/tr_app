package com.tunidesign.camionmicroservice.web;

import com.tunidesign.camionmicroservice.dto.CamionRequestDto;
import com.tunidesign.camionmicroservice.dto.CamionResponseDto;
import com.tunidesign.camionmicroservice.exceptions.CamionIntrouvableException;
import com.tunidesign.camionmicroservice.model.Camion;
import com.tunidesign.camionmicroservice.repository.CamionRepository;
import com.tunidesign.camionmicroservice.service.CamionService;
import com.tunidesign.camionmicroservice.service.CamionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/camion")
public class CamionController {
    @Autowired
    private CamionServiceImpl camionService;
    @GetMapping("/getAll")
    public List<CamionResponseDto> listeCamions() {
        return camionService.getCamions();
    }

    @GetMapping(value = "/getById/{id}")
    public CamionResponseDto afficherUnCamion(@PathVariable Long id) {
        CamionResponseDto camion = camionService.getCamion(id);
        if(camion==null) throw new CamionIntrouvableException("Le camion avec l'id " + id + " est INTROUVABLE. ");
        return camion;
    }

    @PostMapping(value = "/add")
    public CamionResponseDto passerUnCamion(@RequestBody CamionRequestDto camion) {
        return camionService.save(camion);
    }
    @DeleteMapping (value = "/delete/{id}")
    public void supprimerUnCamion(@PathVariable Long id) {
         camionService.deleteCamion(id);
    }
    @PutMapping (value = "/update")
    public CamionResponseDto modiferUnCamion(@RequestBody CamionRequestDto camionRequestDto) {
    	CamionResponseDto camion = camionService.update(camionRequestDto);
        if(camion==null) throw new CamionIntrouvableException("Ce camion  est INTROUVABLE. ");
        else return camion;
    }
}
// methode affecter un camion a un client ?????????
