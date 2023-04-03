package com.tunidesign.assurancemicroservice.mapper;

import com.tunidesign.assurancemicroservice.DTO.AssuranceRequestDTO;
import com.tunidesign.assurancemicroservice.DTO.AssuranceResponseDTO;
import com.tunidesign.assurancemicroservice.model.Assurance;
import org.springframework.stereotype.Component;

@Component
public class AssuranceMapperImpl implements AssuranceMapper {
    @Override
    public AssuranceResponseDTO assuranceToAssuranceDTO(Assurance assurance) {
        return AssuranceResponseDTO.builder()
                .id(assurance.getId())
                .name(assurance.getName())
                .adresse(assurance.getAdresse())
                .email(assurance.getEmail())
                .countryCode(assurance.getCountryCode())
                .dialCode(assurance.getDialCode())
                .phoneNumber(assurance.getPhoneNumber())
                .pictureByte(assurance.getPictureByte())
                .pictureName(assurance.getPictureName())
                .pictureType(assurance.getPictureType())
                .webSite(assurance.getWebSite())
                .build();
    }

    @Override
    public Assurance assuranceRequestDTOToAssurance(AssuranceRequestDTO assuranceRequestDTO) {
        return Assurance.builder()
                .name(assuranceRequestDTO.getName())
                .adresse(assuranceRequestDTO.getAdresse())
                .email(assuranceRequestDTO.getEmail())
                .countryCode(assuranceRequestDTO.getCountryCode())
                .dialCode(assuranceRequestDTO.getDialCode())
                .phoneNumber(assuranceRequestDTO.getPhoneNumber())
                .webSite(assuranceRequestDTO.getWebSite())
                .build();
    }

}
