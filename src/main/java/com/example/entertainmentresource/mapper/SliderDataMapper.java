package com.example.entertainmentresource.mapper;

import com.example.entertainmentresource.dto.EntertainmentDataResponseDTO;
import com.example.entertainmentresource.dto.SliderDataRequestDTO;
import com.example.entertainmentresource.dto.SliderDataResponseDTO;
import com.example.entertainmentresource.models.slider.SliderData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class SliderDataMapper {
    @Autowired
    private EntertainmentDataMapper entertainmentDataMapper;

    public SliderDataResponseDTO toDTO(SliderData sliderData) {
        SliderDataResponseDTO sliderDataDTO = new SliderDataResponseDTO();
        sliderDataDTO.setSliderId(sliderData.getId());
        sliderDataDTO.setHeader(sliderData.getHeader());
        sliderDataDTO.setCardType(sliderData.getCardType());
        List<EntertainmentDataResponseDTO> entertainmentDataDTOList = sliderData.getEntertainmentData().stream().map(entertainmentDataMapper::toDTO).collect(Collectors.toList());
        sliderDataDTO.setEntertainmentData(entertainmentDataDTOList);
        sliderDataDTO.setMaxItems(sliderData.getEntertainmentData().size());
        return sliderDataDTO;
    }

    public SliderData toEntity(SliderDataRequestDTO sliderDataRequestDTO) {
        SliderData sliderData = new SliderData();
        sliderData.setHeader(sliderDataRequestDTO.getHeader());
        sliderData.setCardType(sliderDataRequestDTO.getCardType());
        sliderData.setSortId(sliderDataRequestDTO.getSortId());
        sliderData.setPage(sliderDataRequestDTO.getPage());
        return sliderData;
    }
}
