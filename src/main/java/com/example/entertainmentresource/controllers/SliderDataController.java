package com.example.entertainmentresource.controllers;

import com.example.entertainmentresource.dto.SliderDataRequestDTO;
import com.example.entertainmentresource.dto.SliderDataResponseDTO;
import com.example.entertainmentresource.exceptions.ResourceNotFoundException;
import com.example.entertainmentresource.models.slider.PageType;
import com.example.entertainmentresource.services.SliderDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/slider")
public class SliderDataController {

    @Autowired
    private SliderDataService sliderDataService;


    @PostMapping
    public void addSliderData(@RequestBody SliderDataRequestDTO sliderDataRequestDTO){
        sliderDataService.saveSliderData(sliderDataRequestDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SliderDataResponseDTO> getSliderDataById(@PathVariable("id") Long sliderId) throws ResourceNotFoundException {
        SliderDataResponseDTO sliderDataDTO = sliderDataService.findSliderDataById(sliderId);
        return ResponseEntity.ok().body(sliderDataDTO);
    }

    @GetMapping("/page/{pageType}")
    public ResponseEntity<List<SliderDataResponseDTO>> getPageDataByPageType(@PathVariable("pageType") PageType pageType) {
        List<SliderDataResponseDTO> sliderDataDTOList = sliderDataService.findSliderDataByPage(pageType);
        return ResponseEntity.ok().body(sliderDataDTOList);
    }

    @PutMapping("/entertainment/{id}")
    public void updateSliderEntertainmentData(@PathVariable("id") Long sliderId, @RequestBody List<Long> entertainmentIds) {
            sliderDataService.updateSliderEntertainmentData(sliderId, entertainmentIds);
    }
}
