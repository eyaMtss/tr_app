package com.tunidesign.shiftmicroservice.service;


import com.tunidesign.shiftmicroservice.DTO.ShiftRequestDTO;
import com.tunidesign.shiftmicroservice.DTO.ShiftResponseDTO;

import java.util.List;


public interface ShiftService {
    List<ShiftResponseDTO> getShifts();
    ShiftResponseDTO getShiftById(Long id);
    ShiftResponseDTO save(ShiftRequestDTO shiftRequestDTO);
    void deleteShift(Long id);
    ShiftResponseDTO update(ShiftRequestDTO shiftRequestDTO);
}
