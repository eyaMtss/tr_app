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
@RequestMapping("/shift")
public class ShiftController {
    @Autowired
    private ShiftService shiftService;

    @GetMapping("/test")
    public String test() {
        return "ça marche";
    }
    @GetMapping("/getAll")
    public List<ShiftResponseDTO> listeShifts() {
        return shiftService.getShifts();
    }

    @GetMapping(value = "/getById/{id}")
    public ShiftResponseDTO afficherUnShift(@PathVariable Long id) throws ShiftIntrouvableException {
        ShiftResponseDTO shift = shiftService.getShiftById(id);
        if(shift==null) throw new ShiftIntrouvableException("Le shift avec l'id " + id + " est INTROUVABLE. ");
        return shift;
    }
    @PostMapping(value = "/add")
    public void saveShift(@RequestBody ShiftRequestDTO shiftRequestDTO) {
        shiftService.save(shiftRequestDTO);
    }
    @DeleteMapping (value = "/delete/{id}")
    public void supprimerUnShift(@PathVariable Long id)
    {
        shiftService.deleteShift(id);
    }
    @PutMapping (value = "/update")
    public ShiftResponseDTO modiferUnShift(@RequestBody ShiftRequestDTO shiftRequestDTO) throws ShiftIntrouvableException {
        ShiftResponseDTO shift = shiftService.save(shiftRequestDTO);
        if(shift==null) throw new ShiftIntrouvableException("Ce shift est INTROUVABLE. ");
        return shift;
    }
}
