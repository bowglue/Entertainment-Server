package com.example.entertainmentresource.dto;

import com.example.entertainmentresource.models.entertainment.EntertainmentType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateEntertainmentDataRequestDTO {
    private Long id;
    private String title;
    private String overview;
    private int releaseDate;
    private int runtime;
    private String status;
    private String rent;
    private String streaming;
    private String buy;
    private String genres;
    private int voteAverage;
    private int voteCount;
    private String tagline;
    private String mode;
    private String theme;
    private EntertainmentType entertainmentType;
    private long popularity;
}
