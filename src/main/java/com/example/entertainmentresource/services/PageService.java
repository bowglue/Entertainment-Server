package com.example.entertainmentresource.services;

import com.example.entertainmentresource.dto.EntertainmentDataResponseDTO;
import com.example.entertainmentresource.dto.PageDataResponseDTO;
import com.example.entertainmentresource.dto.SliderDataResponseDTO;
import com.example.entertainmentresource.mapper.PageDataMapper;
import com.example.entertainmentresource.models.entertainment.EntertainmentType;
import com.example.entertainmentresource.models.slider.PageType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PageService {

    private SliderDataService sliderDataService;
    private EntertainmentDataService entertainmentDataService;
    private PageDataMapper pageDataMapper;

    public PageService(SliderDataService sliderDataService, EntertainmentDataService entertainmentDataService, PageDataMapper pageDataMapper) {
        this.sliderDataService = sliderDataService;
        this.entertainmentDataService = entertainmentDataService;
        this.pageDataMapper = pageDataMapper;
    }

    public PageDataResponseDTO findPageData(PageType pageType) {
        List<SliderDataResponseDTO> sliderDataResponseDTOList = sliderDataService.findSliderDataByPage(pageType);
        List<EntertainmentDataResponseDTO> entertainmentDataResponseDTOList = entertainmentDataService.findLimitedEntertainmentDataByEntertainmentType(getEntertainmentType(pageType));
        return pageDataMapper.toDTO(entertainmentDataResponseDTOList, sliderDataResponseDTOList);
    }

    public EntertainmentType getEntertainmentType(PageType pageType){
        if(pageType.equals(PageType.movies)) return EntertainmentType.movie;
        return EntertainmentType.game;
    };
}
