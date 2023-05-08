package com.example.entertainmentresource.controllers;

import com.example.entertainmentresource.dto.EntertainmentDataResponseDTO;
import com.example.entertainmentresource.dto.UpdateEntertainmentDataRequestDTO;
import com.example.entertainmentresource.exceptions.ResourceNotFoundException;
import com.example.entertainmentresource.models.entertainment.EntertainmentData;
import com.example.entertainmentresource.models.entertainment.EntertainmentType;
import com.example.entertainmentresource.services.EntertainmentDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/entertainment")
public class EntertainmentDataController {

    @Autowired
    private EntertainmentDataService entertainmentDataService;

    @PostMapping
    public ResponseEntity<EntertainmentData> addEntertainmentData(@RequestBody EntertainmentData entertainmentData){
        EntertainmentData newEntertainmentData = entertainmentDataService.saveEntertainmentData(entertainmentData);
        return ResponseEntity.ok().body(newEntertainmentData);
    }

    @PutMapping
    public void updateEntertainmentData(@RequestBody UpdateEntertainmentDataRequestDTO updateEntertainmentDataRequestDTO) {
        entertainmentDataService.updateEntertainmentData(updateEntertainmentDataRequestDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntertainmentDataResponseDTO> getEntertainmentDataById(@PathVariable("id") Long entertainmentId) throws ResourceNotFoundException {
        EntertainmentDataResponseDTO entertainmentDataDTO = entertainmentDataService.findEntertainmentDataById(entertainmentId);
        return ResponseEntity.ok().body(entertainmentDataDTO);
    }

    @GetMapping("/type/{entertainmentType}")
    public ResponseEntity<List<EntertainmentDataResponseDTO>> getByEntertainmentType(@PathVariable("entertainmentType") EntertainmentType entertainmentType) {
        List<EntertainmentDataResponseDTO> entertainmentDataDTOs = entertainmentDataService.findByEntertainmentType(entertainmentType);;
        return ResponseEntity.ok().body(entertainmentDataDTOs);
    }

    @GetMapping("/header/{entertainmentType}")
    public ResponseEntity<List<EntertainmentDataResponseDTO>> getHeader (@PathVariable("entertainmentType") EntertainmentType entertainmentType) {
        List<EntertainmentDataResponseDTO> entertainmentDataDTOs = entertainmentDataService.findLimitedEntertainmentDataByEntertainmentType(entertainmentType);
        return ResponseEntity.ok().body(entertainmentDataDTOs);
    }

    @DeleteMapping("/{id}")
    public void deleteEntertainmentData(@PathVariable("id") Long entertainmentId) throws ResourceNotFoundException {
        entertainmentDataService.deleteEntertainmentData(entertainmentId);
    }
}
