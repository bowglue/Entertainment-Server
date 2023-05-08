package com.example.entertainmentresource.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EntertainmentDataResponseDTO {
    private Long id;
    private String title;
    private String genres;
    private int releaseDate;
    private String focus;
    private String wide;
    private String poster;
    private String logo;
}
