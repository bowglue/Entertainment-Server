package com.example.entertainmentresource.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PageDataResponseDTO {
    private List<EntertainmentDataResponseDTO> header;
    private List<SliderDataResponseDTO> rows;
}
