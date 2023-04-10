package com.tunidesign.shiftmicroservice.service;



import com.tunidesign.shiftmicroservice.DTO.ShiftRequestDTO;
import com.tunidesign.shiftmicroservice.DTO.ShiftResponseDTO;
import com.tunidesign.shiftmicroservice.mapper.ShiftMapper;
import com.tunidesign.shiftmicroservice.repository.ShiftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ShiftServiceImpl implements ShiftService {

    @Autowired
    private ShiftRepository shiftRepository;

    @Autowired
    private ShiftMapper shiftMapper;
    @Override
    public List<ShiftResponseDTO> getShifts() {
        return shiftRepository.findAll().stream().map(garage -> shiftMapper.shiftToShiftResponseDTO(garage)).toList();
    }

    @Override
    public ShiftResponseDTO getShiftById(Long id) {
        return shiftMapper.shiftToShiftResponseDTO(shiftRepository.findById(id).get());
    }

    @Override
    public ShiftResponseDTO save(ShiftRequestDTO shiftRequestDTO) {
       return shiftMapper.shiftToShiftResponseDTO(shiftRepository.save(shiftMapper.shiftRequestDTOToShift(shiftRequestDTO)));
    }

    @Override
    public void deleteShift(Long id) {
        shiftRepository.deleteById(id);

    }

    @Override
    public ShiftResponseDTO update(ShiftRequestDTO shiftRequestDTO) {
        return shiftMapper.shiftToShiftResponseDTO(shiftRepository.save(shiftMapper.shiftRequestDTOToShift(shiftRequestDTO)));
    }
}
