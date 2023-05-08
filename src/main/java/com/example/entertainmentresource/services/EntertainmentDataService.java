package com.example.entertainmentresource.services;

import com.example.entertainmentresource.dto.EntertainmentDataResponseDTO;
import com.example.entertainmentresource.dto.UpdateEntertainmentDataRequestDTO;
import com.example.entertainmentresource.exceptions.ResourceNotFoundException;
import com.example.entertainmentresource.mapper.EntertainmentDataMapper;
import com.example.entertainmentresource.models.entertainment.EntertainmentData;
import com.example.entertainmentresource.models.entertainment.EntertainmentType;
import com.example.entertainmentresource.models.image.FocusImage;
import com.example.entertainmentresource.models.image.LogoImage;
import com.example.entertainmentresource.models.image.PosterImage;
import com.example.entertainmentresource.models.image.WideImage;
import com.example.entertainmentresource.repositories.EntertainmentDataRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EntertainmentDataService {
    private EntertainmentDataRepository entertainmentDataRepository;
    private BaseImageService baseImageService;
    private EntertainmentDataMapper entertainmentDataMapper;

    public EntertainmentDataService(EntertainmentDataRepository entertainmentDataRepository, BaseImageService baseImageService, EntertainmentDataMapper entertainmentDataMapper) {
        this.entertainmentDataRepository = entertainmentDataRepository;
        this.baseImageService = baseImageService;
        this.entertainmentDataMapper = entertainmentDataMapper;
    }

    public List<EntertainmentDataResponseDTO> findByEntertainmentType(EntertainmentType entertainmentType) {
        List<EntertainmentData> entertainmentDataList  = entertainmentDataRepository.findByEntertainmentType(entertainmentType);
        return entertainmentDataList.stream().map(entertainmentDataMapper::toDTO).collect(Collectors.toList());
    }

    public List<EntertainmentDataResponseDTO> findLimitedEntertainmentDataByEntertainmentType(EntertainmentType entertainmentType) {
        List<EntertainmentData> entertainmentDataList  = entertainmentDataRepository.findLimitedEntertainmentDataByEntertainmentType(entertainmentType, 5);
        return entertainmentDataList.stream().map(entertainmentDataMapper::toDTO).collect(Collectors.toList());
    }

    public EntertainmentData saveEntertainmentData(EntertainmentData entertainmentData) {
       List<FocusImage> focusImages = entertainmentData.getFocusImages();
       List<WideImage> wideImages = entertainmentData.getWideImages();
       List<PosterImage> posterImages = entertainmentData.getPosterImages();
       List<LogoImage> logoImages = entertainmentData.getLogoImages();

       focusImages.forEach(focusImage -> focusImage.setEntertainmentData(entertainmentData));
       wideImages.forEach(wideImage -> wideImage.setEntertainmentData(entertainmentData));
       posterImages.forEach(posterImage -> posterImage.setEntertainmentData(entertainmentData));
       logoImages.forEach(logoImage -> logoImage.setEntertainmentData(entertainmentData));

       entertainmentDataRepository.saveAndFlush(entertainmentData);
       baseImageService.saveAllImages(focusImages);
       baseImageService.saveAllImages(wideImages);
       baseImageService.saveAllImages(posterImages);
       baseImageService.saveAllImages(logoImages);

       return entertainmentData;
    }

    public EntertainmentDataResponseDTO findEntertainmentDataById(Long id) {
        EntertainmentData entertainmentData = entertainmentDataRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Entertainment data not found for this id :: " + id));
        return  entertainmentDataMapper.toDTO(entertainmentData);
    }


    public void updateEntertainmentData(UpdateEntertainmentDataRequestDTO updateEntertainmentDataRequestDTO) {
        Long id = updateEntertainmentDataRequestDTO.getId();
        EntertainmentData existingEntertainmentData = entertainmentDataRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Entertainment data not found for this id :: " + id));
        /*existingEntertainmentData.setPopularity(updateEntertainmentDataRequestDTO.getPopularity());
        System.out.print(updateEntertainmentDataRequestDTO.getPopularity());*/
        BeanUtils.copyProperties(updateEntertainmentDataRequestDTO, existingEntertainmentData);

        entertainmentDataRepository.saveAndFlush(existingEntertainmentData);
    }


    public void deleteEntertainmentData(Long id) {
        EntertainmentData entertainmentData = entertainmentDataRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Entertainment data not found for this id :: " + id));
        entertainmentDataRepository.delete(entertainmentData);
    }
}
