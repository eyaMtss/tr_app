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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.tunidesign.backendutilisateurmicroservice.DTO.PictureRequestDTO;
import com.tunidesign.backendutilisateurmicroservice.DTO.UserRequestDTO;
import com.tunidesign.backendutilisateurmicroservice.DTO.UserResponseDTO;
import com.tunidesign.backendutilisateurmicroservice.exceptions.CustomException;
import com.tunidesign.backendutilisateurmicroservice.service.UserServiceImpl;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

@RestController
@CrossOrigin("*")
public class UserController {
	@Autowired
	private UserServiceImpl userService;
	static Logger logger = LoggerFactory.getLogger(UserController.class);

	@PostMapping(path = "/Users")
	public ResponseEntity<UserResponseDTO> save(@Valid @RequestBody UserRequestDTO userRequestDTO) {
		try {
			return new ResponseEntity<>(userService.addUser(userRequestDTO), HttpStatus.CREATED);
		} catch (Exception e) {
			throw new CustomException(e.getMessage());
		}
	}

	@PostMapping("/Users/uploadImage/{userId}")
	public ResponseEntity<UserResponseDTO> uplaodImage(@PathVariable Long userId,
			@RequestParam("imageFile") MultipartFile file) throws IOException {

		logger.info("Original Image Byte Size - " + file.getBytes().length);
		// add image
		PictureRequestDTO pictureRequestDTO = new PictureRequestDTO();
		PictureRequestDTO.builder()
			.userId(userId)
			.pictureName(file.getOriginalFilename())
			.pictureType(file.getContentType())
			.pictureByte(compressBytes(file.getBytes()))
			.build();
		return new ResponseEntity<>(userService.uploadPicture(pictureRequestDTO), HttpStatus.ACCEPTED);
	}

	@PutMapping("/Users")
	public ResponseEntity<UserResponseDTO> updateUser(@Valid @RequestBody UserRequestDTO userRequestDTO) {
		
		try {
			if(userService.isExist(userRequestDTO.getUserId())) {
				return ResponseEntity.accepted().body(userService.updateUser(userRequestDTO));
			}
			else throw new EntityNotFoundException("User doesn't exist");
			
		} catch (Exception e) {
			throw new CustomException(e.getMessage());
		}
	}

	@GetMapping("/Users")
	public ResponseEntity<List<UserResponseDTO>> getAllUsers() {
		return ResponseEntity.ok().body(userService.getUsers());
	}
	
	@GetMapping("/Users/{userId}")
	public ResponseEntity<UserResponseDTO> getUser(@PathVariable Long userId) {
		try {
			return ResponseEntity.ok().body(userService.getUser(userId));
		} catch (Exception ex) {
			throw new EntityNotFoundException("User doesn't exist");
		}
	}

	@DeleteMapping("/Users/{userId}")
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
