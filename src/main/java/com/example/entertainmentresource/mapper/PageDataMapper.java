package com.example.entertainmentresource.mapper;

import com.example.entertainmentresource.dto.EntertainmentDataResponseDTO;
import com.example.entertainmentresource.dto.PageDataResponseDTO;

import com.example.entertainmentresource.dto.SliderDataResponseDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PageDataMapper {
    public PageDataResponseDTO toDTO(List<EntertainmentDataResponseDTO> entertainmentDataResponseDTOList, List<SliderDataResponseDTO> sliderDataResponseDTOList) {
        PageDataResponseDTO pageDataResponseDTO = new PageDataResponseDTO();
        pageDataResponseDTO.setHeader(entertainmentDataResponseDTOList);
        pageDataResponseDTO.setRows(sliderDataResponseDTOList);
        return pageDataResponseDTO;
    }
}
