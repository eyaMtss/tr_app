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
import com.tunidesign.utilisateurmicroservice.model.enumeration.Role;
import com.tunidesign.utilisateurmicroservice.model.enumeration.Status;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;
import java.util.Optional;

public interface UserService {
	User addUser(User user) throws NoSuchAlgorithmException, InvalidKeySpecException;
	User updateRole(Long userId, Role role);
	User getUser(Long userId);
	User getByUsername(String username);
	User uploadPicture(PictureRequestDTO pictureRequestDTO);
	User updateUser(User user);
	User changeStatus(Long userId, Status status);
	
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



	void deleteUser(Long userId);
	
	Boolean isExist(Long userId);
	Boolean isExistByUsername(String username);
	
	User getUserByUsernameOrEmail(String identifier);
	Optional<User> getUserByEmail(String email);
	//Optional<User> getUserByUsername(String login);
	public User updateCompletedRegistration(String username);
}
