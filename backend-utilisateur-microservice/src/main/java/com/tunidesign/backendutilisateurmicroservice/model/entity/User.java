package com.tunidesign.backendutilisateurmicroservice.model.entity;

import java.util.Date;

import com.tunidesign.backendutilisateurmicroservice.model.annotations.passwordmatches.PasswordMatches;
import com.tunidesign.backendutilisateurmicroservice.model.annotations.validpassword.ValidPassword;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long userId;
	private String firstname;
	private String lasstname;
	private Integer gender;
	private Date birthdate;
	
	//Address
	private String country;
	private String governorate;
	private String city;
	private Integer zipCode;
	private Integer homeCode;
	
	//Contact
	@Email
	private String email;
	private Long phoneNumber;
	
	//Picture
	private String pictureName;
	private String pictureType;
    //image bytes can have large lengths so we specify a value
    //which is more than the default length for picByte column
	@Lob
	@Column(length = 1000000000, columnDefinition="LONGBLOB")
	private byte[] pictureByte; 
	
	//Authentication
	private String login;
	@ValidPassword
	private String password;
	@PasswordMatches
	private String confirmPassword;
}
