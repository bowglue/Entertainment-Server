package com.example.entertainmentresource.dto;

import com.example.entertainmentresource.models.slider.CardType;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SliderDataResponseDTO {
    private Long sliderId;
    private String header;
    private CardType cardType;
    private List<EntertainmentDataResponseDTO> entertainmentData;
    private int maxItems;
}
