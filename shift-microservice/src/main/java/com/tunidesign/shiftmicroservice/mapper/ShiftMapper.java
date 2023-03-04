package com.tunidesign.shiftmicroservice.mapper;


import com.tunidesign.shiftmicroservice.DTO.ShiftRequestDTO;
import com.tunidesign.shiftmicroservice.DTO.ShiftResponseDTO;
import com.tunidesign.shiftmicroservice.model.Shift;

public interface ShiftMapper {
    ShiftResponseDTO shiftToShiftResponseDTO(Shift shift);
    Shift shiftRequestDTOToShift(ShiftRequestDTO shiftRequestDTO);
}
