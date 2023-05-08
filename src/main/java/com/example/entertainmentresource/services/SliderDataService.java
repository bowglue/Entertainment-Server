package com.example.entertainmentresource.services;

import com.example.entertainmentresource.dto.SliderDataRequestDTO;
import com.example.entertainmentresource.dto.SliderDataResponseDTO;
import com.example.entertainmentresource.exceptions.ResourceNotFoundException;
import com.example.entertainmentresource.mapper.SliderDataMapper;
import com.example.entertainmentresource.models.entertainment.EntertainmentData;
import com.example.entertainmentresource.models.slider.PageType;
import com.example.entertainmentresource.models.slider.SliderData;
import com.example.entertainmentresource.repositories.EntertainmentDataRepository;
import com.example.entertainmentresource.repositories.SliderDataRepository;
import com.example.entertainmentresource.utils.ListSorter;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SliderDataService {
    private SliderDataRepository sliderDataRepository;
    private EntertainmentDataRepository entertainmentDataRepository;
    private SliderDataMapper sliderDataMapper;


    public SliderDataService(SliderDataRepository sliderDataRepository, EntertainmentDataRepository entertainmentDataRepository, SliderDataMapper sliderDataMapper) {
        this.sliderDataRepository = sliderDataRepository;
        this.entertainmentDataRepository = entertainmentDataRepository;
        this.sliderDataMapper = sliderDataMapper;
    }

    public void saveSliderData(SliderDataRequestDTO sliderDataRequestDTO) {
        List<EntertainmentData> entertainmentDataList = entertainmentDataRepository.findAllById(sliderDataRequestDTO.getEntertainmentIds());
        SliderData sliderData = sliderDataMapper.toEntity(sliderDataRequestDTO);
        sliderData.setEntertainmentData(entertainmentDataList);
        sliderDataRepository.saveAndFlush(sliderData);
    }

    public SliderDataResponseDTO findSliderDataById(Long id) {
        SliderData sliderData = sliderDataRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Entertainment data not found for this id :: " + id));
        ListSorter.sort(sliderData.getEntertainmentData(), EntertainmentData::getVoteAverage, false);

        return sliderDataMapper.toDTO(sliderData);
    }

    public List<SliderDataResponseDTO> findSliderDataByPage(PageType pageType) {
        List<SliderData> sliderDataList = sliderDataRepository.findByPageOrderBySortId(pageType);
        return sliderDataList.stream().peek(sliderData -> ListSorter.sort(sliderData.getEntertainmentData(), EntertainmentData::getVoteAverage, false)).map(sliderDataMapper::toDTO).collect(Collectors.toList());
    }

    public void updateSliderEntertainmentData(Long sliderId, List<Long> entertainmentIds) {
        SliderData sliderData = sliderDataRepository.findById(sliderId).orElseThrow(() -> new ResourceNotFoundException("Entertainment data not found for this id :: " + sliderId));
        List<EntertainmentData> entertainmentDataList = entertainmentDataRepository.findAllById(entertainmentIds);
        sliderData.setEntertainmentData(entertainmentDataList);
        sliderDataRepository.saveAndFlush(sliderData);
    }
}
