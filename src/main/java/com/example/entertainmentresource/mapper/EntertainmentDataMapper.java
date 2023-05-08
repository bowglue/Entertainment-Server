package com.example.entertainmentresource.mapper;

import com.example.entertainmentresource.dto.EntertainmentDataResponseDTO;
import com.example.entertainmentresource.models.image.BaseImage;
import com.example.entertainmentresource.models.entertainment.EntertainmentData;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EntertainmentDataMapper {
    public EntertainmentDataResponseDTO toDTO(EntertainmentData entertainmentData) {
        EntertainmentDataResponseDTO entertainmentDataDTO = new EntertainmentDataResponseDTO();
        entertainmentDataDTO.setId(entertainmentData.getId());
        entertainmentDataDTO.setTitle(entertainmentData.getTitle());
        entertainmentDataDTO.setGenres(entertainmentData.getGenres());
        entertainmentDataDTO.setReleaseDate(entertainmentData.getReleaseDate());
        entertainmentDataDTO.setFocus(generateImageLink(entertainmentData.getFocusImages()));
        entertainmentDataDTO.setWide(generateImageLink(entertainmentData.getWideImages()));
        entertainmentDataDTO.setPoster(generateImageLink(entertainmentData.getPosterImages()));
        entertainmentDataDTO.setLogo(generateImageLink(entertainmentData.getLogoImages()));
        return entertainmentDataDTO;
    }

    private <T extends BaseImage> String generateImageLink(List<T> baseImages) {
        BaseImage baseImage = baseImages.get(0);
        String imageLink = "https://i.imgur.com/" + baseImage.getLinkId() + "." + baseImage.getType().split("/")[1];
        return imageLink;
    }
}
