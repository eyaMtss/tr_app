package com.tunidesign.backendutilisateurmicroservice.service;

import com.tunidesign.backendutilisateurmicroservice.DTO.PictureRequestDTO;
import com.tunidesign.backendutilisateurmicroservice.DTO.UserRequestDTO;
import com.tunidesign.backendutilisateurmicroservice.DTO.UserResponseDTO;

import java.util.List;

public interface UserService {
	UserResponseDTO addUser(UserRequestDTO userRequestDTO);
	UserResponseDTO addClient(UserRequestDTO userRequestDTO);
	UserResponseDTO addTA(UserRequestDTO userRequestDTO);
	UserResponseDTO addDriver(UserRequestDTO userRequestDTO);
	UserResponseDTO addCompanyAdmin(UserRequestDTO userRequestDTO);
	UserResponseDTO addAgencyAdmin(UserRequestDTO userRequestDTO);
	UserResponseDTO addInsuranceAdmin(UserRequestDTO userRequestDTO);
	UserResponseDTO addExpert(UserRequestDTO userRequestDTO);
	UserResponseDTO addPrestataire(UserRequestDTO userRequestDTO);
	
	UserResponseDTO uploadPicture(PictureRequestDTO pictureRequestDTO);

	UserResponseDTO updateUser(UserRequestDTO UserRequestDTO);

	List<UserResponseDTO> getClients();
	List<UserResponseDTO> getDrivers(Long companyId);
	List<UserResponseDTO> getTAs(Long companyId);
	List<UserResponseDTO> getExperts(Long companyId);
	List<UserResponseDTO> getCompanyEmployees(Long companyId); 
	List<UserResponseDTO> getAgencyEmployees(Long agencyId); 
	List<UserResponseDTO> getInsuranceEmployees(Long insuranceId);
	List<UserResponseDTO> getUsers();

	UserResponseDTO getUser(Long userId);

	void deleteUser(Long userId);
	
	Boolean isExist(Long userId);

}
