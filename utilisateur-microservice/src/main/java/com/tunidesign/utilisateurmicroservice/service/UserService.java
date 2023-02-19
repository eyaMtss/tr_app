package com.tunidesign.utilisateurmicroservice.service;

import com.tunidesign.utilisateurmicroservice.DTO.AgencyUserRequestDTO;
import com.tunidesign.utilisateurmicroservice.DTO.AgencyUserResponseDTO;
import com.tunidesign.utilisateurmicroservice.DTO.AuthenticationResponseDTO;
import com.tunidesign.utilisateurmicroservice.DTO.ClientRequestDTO;
import com.tunidesign.utilisateurmicroservice.DTO.ClientResponseDTO;
import com.tunidesign.utilisateurmicroservice.DTO.CompanyUserRequestDTO;
import com.tunidesign.utilisateurmicroservice.DTO.CompanyUserResponseDTO;
import com.tunidesign.utilisateurmicroservice.DTO.InsuranceUserRequestDTO;
import com.tunidesign.utilisateurmicroservice.DTO.InsuranceUserResponseDTO;
import com.tunidesign.utilisateurmicroservice.DTO.PictureRequestDTO;
import com.tunidesign.utilisateurmicroservice.DTO.UserRequestDTO;
import com.tunidesign.utilisateurmicroservice.DTO.UserResponseDTO;
import com.tunidesign.utilisateurmicroservice.model.entity.User;
import com.tunidesign.utilisateurmicroservice.model.enumeration.Status;

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
	
	AuthenticationResponseDTO getUserByLoginOrEmail(String identifier, String password);

}
