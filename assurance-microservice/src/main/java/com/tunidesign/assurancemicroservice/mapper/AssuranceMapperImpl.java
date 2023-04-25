package com.tunidesign.assurancemicroservice.mapper;

import com.tunidesign.assurancemicroservice.dto.AssuranceRequestDto;
import com.tunidesign.assurancemicroservice.dto.AssuranceResponseDto;
import com.tunidesign.assurancemicroservice.model.Assurance;
import org.springframework.stereotype.Component;

@Component
public class AssuranceMapperImpl implements AssuranceMapper {
    @Override
    public AssuranceResponseDto assuranceToAssuranceDto(Assurance assurance) {
        return AssuranceResponseDto.builder()
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
    public Assurance assuranceRequestDtoToAssurance(AssuranceRequestDto assuranceRequestDto) {
        return Assurance.builder()
                .name(assuranceRequestDto.getName())
                .adresse(assuranceRequestDto.getAdresse())
                .email(assuranceRequestDto.getEmail())
                .countryCode(assuranceRequestDto.getCountryCode())
                .dialCode(assuranceRequestDto.getDialCode())
                .phoneNumber(assuranceRequestDto.getPhoneNumber())
                .webSite(assuranceRequestDto.getWebSite())
                .build();
    }

}
