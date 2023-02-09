package com.tunidesign.backendutilisateurmicroservice.service;

import com.tunidesign.backendutilisateurmicroservice.DTO.AgencyUserRequestDTO;
import com.tunidesign.backendutilisateurmicroservice.DTO.AgencyUserResponseDTO;
import com.tunidesign.backendutilisateurmicroservice.DTO.ClientRequestDTO;
import com.tunidesign.backendutilisateurmicroservice.DTO.ClientResponseDTO;
import com.tunidesign.backendutilisateurmicroservice.DTO.CompanyUserRequestDTO;
import com.tunidesign.backendutilisateurmicroservice.DTO.CompanyUserResponseDTO;
import com.tunidesign.backendutilisateurmicroservice.DTO.InsuranceUserRequestDTO;
import com.tunidesign.backendutilisateurmicroservice.DTO.InsuranceUserResponseDTO;
import com.tunidesign.backendutilisateurmicroservice.DTO.PictureRequestDTO;
import com.tunidesign.backendutilisateurmicroservice.DTO.UserRequestDTO;
import com.tunidesign.backendutilisateurmicroservice.DTO.UserResponseDTO;
import com.tunidesign.backendutilisateurmicroservice.model.entity.User;

import java.util.List;

public interface UserService {
	UserResponseDTO addUser(User user);
	ClientResponseDTO addClient(ClientRequestDTO clientRequestDTO);
	CompanyUserResponseDTO addTA(CompanyUserRequestDTO taUserRequestDTO);
	CompanyUserResponseDTO addDriver(CompanyUserRequestDTO driverRequestDTO);
	CompanyUserResponseDTO addCompanyAdmin(CompanyUserRequestDTO adminRequestDTO);
	AgencyUserResponseDTO addAgencyAdmin(AgencyUserRequestDTO adminUserRequestDTO);
	AgencyUserResponseDTO addExpert(AgencyUserRequestDTO expertRequestDTO);
	InsuranceUserResponseDTO addInsuranceAdmin(InsuranceUserRequestDTO adminRequestDTO);
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
