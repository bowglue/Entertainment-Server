package com.example.entertainmentresource.controllers;

import com.example.entertainmentresource.dto.PageDataResponseDTO;
import com.example.entertainmentresource.models.slider.PageType;
import com.example.entertainmentresource.services.EntertainmentDataService;
import com.example.entertainmentresource.services.PageService;
import com.example.entertainmentresource.services.SliderDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/page")
public class PageController {
    @Autowired
    private PageService pageService;

    @GetMapping("{pageType}")
    public ResponseEntity<PageDataResponseDTO> getPageData(@PathVariable("pageType") PageType pageType) {
        PageDataResponseDTO pageDataResponseDTO = pageService.findPageData(pageType);
        return ResponseEntity.ok().body(pageDataResponseDTO);
    }
}
