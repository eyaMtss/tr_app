package com.tunidesign.backendutilisateurmicroservice.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.zip.Deflater;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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
import com.tunidesign.backendutilisateurmicroservice.exceptions.CustomException;
import com.tunidesign.backendutilisateurmicroservice.service.UserServiceImpl;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

@RestController
@CrossOrigin("*")
@RequestMapping("/Users")
public class UserController {
	@Autowired
	private UserServiceImpl userService;
	static Logger logger = LoggerFactory.getLogger(UserController.class);

	@PostMapping(path = "/AddClient")
	public ResponseEntity<ClientResponseDTO> addClient(@Valid @RequestBody ClientRequestDTO clientRequestDTO) {
		//try {
			return new ResponseEntity<>(userService.addClient(clientRequestDTO), HttpStatus.CREATED);
		//} catch (Exception e) {
		//	throw new CustomException(e.getMessage());
		//}
	}
	@PostMapping(path = "/AddDriver")
	public ResponseEntity<CompanyUserResponseDTO> addDriver(@Valid @RequestBody CompanyUserRequestDTO driverRequestDTO) {
		try {
			return new ResponseEntity<>(userService.addDriver(driverRequestDTO), HttpStatus.CREATED);
		} catch (Exception e) {
			throw new CustomException(e.getMessage());
		}
	}
	@PostMapping(path = "/AddTA")
	public ResponseEntity<CompanyUserResponseDTO> addTA(@Valid @RequestBody CompanyUserRequestDTO taRequestDTO) {
		try {
			return new ResponseEntity<>(userService.addTA(taRequestDTO), HttpStatus.CREATED);
		} catch (Exception e) {
			throw new CustomException(e.getMessage());
		}
	}
	@PostMapping(path = "/AddCompanyAdmin")
	public ResponseEntity<CompanyUserResponseDTO> addCompanyAdmin(@Valid @RequestBody CompanyUserRequestDTO adminRequestDTO) {
		try {
			return new ResponseEntity<>(userService.addCompanyAdmin(adminRequestDTO), HttpStatus.CREATED);
		} catch (Exception e) {
			throw new CustomException(e.getMessage());
		}
	}
	@PostMapping(path = "/AddExpert")
	public ResponseEntity<AgencyUserResponseDTO> addExpert(@Valid @RequestBody AgencyUserRequestDTO expertRequestDTO) {
		try {
			return new ResponseEntity<>(userService.addExpert(expertRequestDTO), HttpStatus.CREATED);
		} catch (Exception e) {
			throw new CustomException(e.getMessage());
		}
	}
	
	@PostMapping(path = "/AddAgencyAdmin")
	public ResponseEntity<AgencyUserResponseDTO> addAgencyAdmin(@Valid @RequestBody AgencyUserRequestDTO adminRequestDTO) {
		try {
			return new ResponseEntity<>(userService.addAgencyAdmin(adminRequestDTO), HttpStatus.CREATED);
		} catch (Exception e) {
			throw new CustomException(e.getMessage());
		}
	}
	@PostMapping(path = "/AddInsuranceAdmin")
	public ResponseEntity<InsuranceUserResponseDTO> addInsuranceAdmin(@Valid @RequestBody InsuranceUserRequestDTO adminRequestDTO) {
		try {
			return new ResponseEntity<>(userService.addInsuranceAdmin(adminRequestDTO), HttpStatus.CREATED);
		} catch (Exception e) {
			throw new CustomException(e.getMessage());
		}
	}
	@PostMapping(path = "/AddPrestataire")
	public ResponseEntity<UserResponseDTO> addPrestataire(@Valid @RequestBody UserRequestDTO userRequestDTO) {
		try {
			return new ResponseEntity<>(userService.addPrestataire(userRequestDTO), HttpStatus.CREATED);
		} catch (Exception e) {
			throw new CustomException(e.getMessage());
		}
	}
	@PostMapping("/uploadImage/{userId}")
	public ResponseEntity<UserResponseDTO> uplaodImage(@PathVariable Long userId,
			@RequestParam("imageFile") MultipartFile file) throws IOException {

		logger.info("Original Image Byte Size - " + file.getBytes().length);
		// add image
		PictureRequestDTO pictureRequestDTO = new PictureRequestDTO();
		PictureRequestDTO.builder().userId(userId).pictureName(file.getOriginalFilename())
				.pictureType(file.getContentType()).pictureByte(compressBytes(file.getBytes())).build();
		return new ResponseEntity<>(userService.uploadPicture(pictureRequestDTO), HttpStatus.ACCEPTED);
	}

	@PutMapping("")
	public ResponseEntity<UserResponseDTO> updateUser(@Valid @RequestBody UserRequestDTO userRequestDTO) {

		try {
			if (userService.isExist(userRequestDTO.getUserId())) {
				return ResponseEntity.accepted().body(userService.updateUser(userRequestDTO));
			} else
				throw new EntityNotFoundException("User doesn't exist");

		} catch (Exception e) {
			throw new CustomException(e.getMessage());
		}
	}

//	  @GetMapping("/users")
//	    public ResponseEntity<List<User>> getAllUsers(@AuthenticationPrincipal User user) {
//	        if (user.getRole() == Role.ADMIN) {
//	            List<User> users = userService.findAll();
//	            return ResponseEntity.ok(users);
//	        } else {
//	            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
//	        }
//	    }
	@GetMapping("/Clients")
	public ResponseEntity<List<UserResponseDTO>> getClients() {
		return ResponseEntity.ok().body(userService.getUsers());
	}

	@GetMapping("/Drivers/{companyId}")
	public ResponseEntity<List<UserResponseDTO>> getDrivers(@PathVariable Long companyId) {
		return ResponseEntity.ok().body(userService.getDrivers(companyId));
	}

	@GetMapping("/TA/{companyId}")
	public ResponseEntity<List<UserResponseDTO>> getTAs(@PathVariable Long companyId) {
		return ResponseEntity.ok().body(userService.getTAs(companyId));
	}

	@GetMapping("/CompanyEmployees/{companyId}")
	public ResponseEntity<List<UserResponseDTO>> getCompanyEmployees(@PathVariable Long companyId) {
		return ResponseEntity.ok().body(userService.getCompanyEmployees(companyId));
	}
	
	@GetMapping("/AgencyEmployees/{agencyId}")
	public ResponseEntity<List<UserResponseDTO>> getAgencyEmployees(@PathVariable Long agencyId) {
		return ResponseEntity.ok().body(userService.getAgencyEmployees(agencyId));
	}

	@GetMapping("/InsuranceEmployees/{insuranceId}")
	public ResponseEntity<List<UserResponseDTO>> getInsuranceEmployees(@PathVariable Long insuranceId) {
		return ResponseEntity.ok().body(userService.getInsuranceEmployees(insuranceId));
	}

	@GetMapping("")
	public ResponseEntity<List<UserResponseDTO>> getAllUsers() {
		return ResponseEntity.ok().body(userService.getUsers());
	}

	@GetMapping("/{userId}")
	public ResponseEntity<UserResponseDTO> getUser(@PathVariable Long userId) {
		try {
			return ResponseEntity.ok().body(userService.getUser(userId));
		} catch (Exception ex) {
			throw new EntityNotFoundException("User doesn't exist");
		}
	}

	@DeleteMapping("/{userId}")
	public ResponseEntity<?> deleteUser(@PathVariable Long userId) {
		try {
			userService.deleteUser(userId);
			return ResponseEntity.noContent().build();
		} catch (Exception ex) {
			throw new EntityNotFoundException("User doesn't exist");
		}
	}

	// compress the image bytes before storing it in the database
	public static byte[] compressBytes(byte[] data) {
		Deflater deflater = new Deflater();
		deflater.setInput(data);
		deflater.finish();

		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
		byte[] buffer = new byte[1024];
		while (!deflater.finished()) {
			int count = deflater.deflate(buffer);
			outputStream.write(buffer, 0, count);
		}
		try {
			outputStream.close();
		} catch (IOException e) {
		}
		logger.info("Compressed Image Byte Size - " + outputStream.toByteArray().length);

		return outputStream.toByteArray();
	}

}
