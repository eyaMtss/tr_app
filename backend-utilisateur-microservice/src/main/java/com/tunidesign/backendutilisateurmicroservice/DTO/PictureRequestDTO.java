package com.tunidesign.backendutilisateurmicroservice.DTO;

import jakarta.persistence.Column;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PictureRequestDTO {
	private Long userId;
	// Picture
	private String pictureName;
	private String pictureType;
	// image bytes can have large lengths so we specify a value
	// which is more than the default length for picByte column
	@Lob
	@Column(length = 1000000000, columnDefinition = "LONGBLOB")
	private byte[] pictureByte;
}
