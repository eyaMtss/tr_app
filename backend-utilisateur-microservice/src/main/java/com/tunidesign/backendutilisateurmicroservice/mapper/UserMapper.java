package com.tunidesign.backendutilisateurmicroservice.mapper;

import com.tunidesign.backendutilisateurmicroservice.DTO.UserRequestDTO;
import com.tunidesign.backendutilisateurmicroservice.DTO.UserResponseDTO;
import com.tunidesign.backendutilisateurmicroservice.model.entity.User;

public interface UserMapper {
	UserResponseDTO userToUserResponseDTO(User user);
	User userRequestDTOToUser(UserRequestDTO userRequestDTO);
	
//	ShiftResponseDTO shiftToShiftDTO(Shift shift);
//	Shift shiftRequestDTOToShift(ShiftRequestDTO shiftRequestDTO);

}
