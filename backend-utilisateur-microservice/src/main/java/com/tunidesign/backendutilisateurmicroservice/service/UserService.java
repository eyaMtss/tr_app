package com.tunidesign.backendutilisateurmicroservice.service;

import com.tunidesign.backendutilisateurmicroservice.DTO.PictureRequestDTO;
import com.tunidesign.backendutilisateurmicroservice.DTO.UserRequestDTO;
import com.tunidesign.backendutilisateurmicroservice.DTO.UserResponseDTO;

import java.util.List;

public interface UserService {
	UserResponseDTO addUser(UserRequestDTO userRequestDTO);
	
	UserResponseDTO uploadPicture(PictureRequestDTO pictureRequestDTO);

	UserResponseDTO updateUser(UserRequestDTO UserRequestDTO);

	List<UserResponseDTO> getUsers();

	UserResponseDTO getUser(Long userId);

	void deleteUser(Long shiftId);
	
	Boolean isExist(Long shiftId);

}
