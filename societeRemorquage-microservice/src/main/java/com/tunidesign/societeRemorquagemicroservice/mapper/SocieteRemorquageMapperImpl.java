package com.tunidesign.societeRemorquagemicroservice.mapper;


import com.tunidesign.societeRemorquagemicroservice.DTO.SocieteRemorquageRequestDTO;
import com.tunidesign.societeRemorquagemicroservice.DTO.SocieteRemorquageResponseDTO;
import com.tunidesign.societeRemorquagemicroservice.model.SocieteRemorquage;
import org.springframework.stereotype.Component;


@Component
public class SocieteRemorquageMapperImpl implements SocieteRemorquageMapper {
    @Override
    public SocieteRemorquageResponseDTO societeToSocieteResponseDTO(SocieteRemorquage societeRemorquage) {
        return SocieteRemorquageResponseDTO.builder()
                .id(societeRemorquage.getId())
                .name(societeRemorquage.getName())
                .email(societeRemorquage.getEmail())
                .country(societeRemorquage.getCountry())
                .city(societeRemorquage.getCity())
                .governorate(societeRemorquage.getGovernorate())
                .zipCode(societeRemorquage.getZipCode())
                .phone1(societeRemorquage.getPhone1())
                .phone2(societeRemorquage.getPhone2())
                .lattitude(societeRemorquage.getLattitude())
                .longitude(societeRemorquage.getLongitude())

                .build();

    }

    @Override
    public SocieteRemorquage societeRequestDTOToSociete(SocieteRemorquageRequestDTO societeRemorquageRequestDTO) {
        return SocieteRemorquage.builder()
                .id(societeRemorquageRequestDTO.getId())
                .name(societeRemorquageRequestDTO.getName())
                .email(societeRemorquageRequestDTO.getEmail())
                .country(societeRemorquageRequestDTO.getCountry())
                .governorate(societeRemorquageRequestDTO.getGovernorate())
                .city(societeRemorquageRequestDTO.getCity())
                .zipCode(societeRemorquageRequestDTO.getZipCode())
                .phone1(societeRemorquageRequestDTO.getPhone1())
                .phone2(societeRemorquageRequestDTO.getPhone2())
                .lattitude(societeRemorquageRequestDTO.getLattitude())
                .longitude(societeRemorquageRequestDTO.getLongitude())
                .build();

    }
}
