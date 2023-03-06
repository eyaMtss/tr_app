package com.tunidesign.shiftmicroservice.mapper;


import com.tunidesign.shiftmicroservice.DTO.ShiftRequestDTO;
import com.tunidesign.shiftmicroservice.DTO.ShiftResponseDTO;
import com.tunidesign.shiftmicroservice.model.Shift;
import org.springframework.stereotype.Component;

import java.time.LocalTime;


@Component
public class ShiftMapperImpl implements ShiftMapper {
    @Override
    public ShiftResponseDTO shiftToShiftResponseDTO(Shift shift) {
       /* ShiftResponseDTO shiftResponseDTO = new ShiftResponseDTO();
        shiftResponseDTO.setId(shift.getId());
        shiftResponseDTO.setDate(shift.getDate());
        shiftResponseDTO.setHeureDebut(shift.getHeureDebut().toString());
        shiftResponseDTO.setHeureFin(shift.getHeureFin().toString());*/

        return ShiftResponseDTO.builder().id(shift.getId())
               .date(shift.getDate())
               .heureFin(shift.getHeureFin().toString())
               .heureDebut(shift.getHeureDebut().toString())
                .idAgence(shift.getIdAgence()).build();

    }

    @Override
    public Shift shiftRequestDTOToShift(ShiftRequestDTO shiftRequestDTO) {
        String timeD = shiftRequestDTO.getHeureDebut();
        String listD[] = timeD.split(":");
        LocalTime heureD=LocalTime.of(Integer.parseInt(listD[0]) ,Integer.parseInt(listD[1]));

        String timeF = shiftRequestDTO.getHeureFin();
        String listF[] = timeF.split(":");
        LocalTime heureF=LocalTime.of(Integer.parseInt(listF[0]) ,Integer.parseInt(listF[1]));
        var shift = Shift.builder().id(shiftRequestDTO.getId())
                        .idAgence(shiftRequestDTO.getIdAgence())
                                .heureFin(heureF)
                                        .heureDebut(heureD)
                                                .date(shiftRequestDTO.getDate()).build();

       return shift;
    }
}
