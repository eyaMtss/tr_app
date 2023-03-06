package com.tunidesign.shiftmicroservice.web;

;

import com.tunidesign.shiftmicroservice.DTO.ShiftRequestDTO;
import com.tunidesign.shiftmicroservice.DTO.ShiftResponseDTO;
import com.tunidesign.shiftmicroservice.exceptions.ShiftIntrouvableException;
import com.tunidesign.shiftmicroservice.service.ShiftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ShiftController {
    @Autowired
    private ShiftService shiftService;

    @GetMapping("/test")
    public String test() {
        return "ça marche";
    }
    @GetMapping("/shifts")
    public List<ShiftResponseDTO> listeShifts() {
        return shiftService.getShifts();
    }

    @GetMapping(value = "/shifts/{id}")
    public ShiftResponseDTO afficherUnShift(@PathVariable int id) throws ShiftIntrouvableException {
        ShiftResponseDTO shift = shiftService.getShiftById(id);
        if(shift==null) throw new ShiftIntrouvableException("Le shift avec l'id " + id + " est INTROUVABLE. ");
        return shift;
    }
    @PostMapping(value = "/SaveShift")
    public void saveShift(@RequestBody ShiftRequestDTO shiftRequestDTO) {
        shiftService.save(shiftRequestDTO);
    }
    @DeleteMapping (value = "/DeleteShift/{id}")
    public void supprimerUnShift(@PathVariable int id)
    {
        shiftService.deleteShift(id);
    }
    @PutMapping (value = "/ModifierUnShift")
    public ShiftResponseDTO modiferUnShift(@RequestBody ShiftRequestDTO shiftRequestDTO) throws ShiftIntrouvableException {
        ShiftResponseDTO shift = shiftService.save(shiftRequestDTO);
        if(shift==null) throw new ShiftIntrouvableException("Ce shift est INTROUVABLE. ");
        return shift;
    }
}
