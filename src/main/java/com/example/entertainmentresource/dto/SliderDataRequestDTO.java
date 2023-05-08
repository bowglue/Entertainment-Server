package com.example.entertainmentresource.dto;

import com.example.entertainmentresource.models.slider.CardType;
import com.example.entertainmentresource.models.slider.PageType;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SliderDataRequestDTO {
    private String header;
    private CardType cardType;
    private int sortId;
    private PageType page;
    private List<Long> entertainmentIds;
}
