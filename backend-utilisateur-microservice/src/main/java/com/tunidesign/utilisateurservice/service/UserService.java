package com.tunidesign.utilisateurservice.service;

import com.tunidesign.utilisateurservice.DTO.AgencyUserRequestDTO;
import com.tunidesign.utilisateurservice.DTO.AgencyUserResponseDTO;
import com.tunidesign.utilisateurservice.DTO.AuthenticationResponseDTO;
import com.tunidesign.utilisateurservice.DTO.ClientRequestDTO;
import com.tunidesign.utilisateurservice.DTO.ClientResponseDTO;
import com.tunidesign.utilisateurservice.DTO.CompanyUserRequestDTO;
import com.tunidesign.utilisateurservice.DTO.CompanyUserResponseDTO;
import com.tunidesign.utilisateurservice.DTO.InsuranceUserRequestDTO;
import com.tunidesign.utilisateurservice.DTO.InsuranceUserResponseDTO;
import com.tunidesign.utilisateurservice.DTO.PictureRequestDTO;
import com.tunidesign.utilisateurservice.DTO.UserRequestDTO;
import com.tunidesign.utilisateurservice.DTO.UserResponseDTO;
import com.tunidesign.utilisateurservice.model.entity.User;
import com.tunidesign.utilisateurservice.model.enumeration.Status;

import java.util.List;

public interface UserService {
	UserResponseDTO addUser(User user);
	ClientResponseDTO addClient(ClientRequestDTO clientRequestDTO);
	CompanyUserResponseDTO addTA(CompanyUserRequestDTO taUserRequestDTO);
	CompanyUserResponseDTO addDriver(CompanyUserRequestDTO driverRequestDTO);
	CompanyUserResponseDTO addCompanyAdmin(CompanyUserRequestDTO adminRequestDTO);
	AgencyUserResponseDTO addAgencyAdmin(AgencyUserRequestDTO adminUserRequestDTO);
	InsuranceUserResponseDTO addExpert(InsuranceUserRequestDTO expertRequestDTO);
	InsuranceUserResponseDTO addInsuranceAdmin(InsuranceUserRequestDTO adminRequestDTO);
	UserResponseDTO addPrestataire(UserRequestDTO userRequestDTO);
	
	UserResponseDTO uploadPicture(PictureRequestDTO pictureRequestDTO);

	UserResponseDTO updateUser(UserRequestDTO UserRequestDTO);
	User changeStatus(Long userId, Status status);
	AgencyUserResponseDTO updateAgencyStatus(Long userId, Status status);
	CompanyUserResponseDTO updateCompanyStatus(Long userId, Status status);
	InsuranceUserResponseDTO updateInsuranceStatus(Long userId, Status status);
	
	List<ClientResponseDTO> getClients();
	List<CompanyUserResponseDTO> getDrivers(Long companyId);
	List<CompanyUserResponseDTO> getTAs(Long companyId);
	List<CompanyUserResponseDTO> getCompanyAdmins(Long companyId);
	List<CompanyUserResponseDTO> getCompanyEmployees(Long companyId); 
	List<AgencyUserResponseDTO> getAgencyAdmins(Long agencyId);
	List<AgencyUserResponseDTO> getAgencyEmployees(Long agencyId); 
	List<InsuranceUserResponseDTO> getExperts(Long insuranceId);
	List<InsuranceUserResponseDTO> getInsuranceAdmins(Long insuranceId);
	List<InsuranceUserResponseDTO> getInsuranceEmployees(Long insuranceId);
	List<UserResponseDTO> getUsers();

	UserResponseDTO getUser(Long userId);

	void deleteUser(Long userId);
	
	Boolean isExist(Long userId);
	
	AuthenticationResponseDTO getUserByLoginOrEmail(String login, String email, String password);

}
