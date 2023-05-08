package com.example.entertainmentresource.interfaces;

import com.example.entertainmentresource.models.image.FocusImage;
import com.example.entertainmentresource.models.image.LogoImage;

import java.util.List;

public interface HeaderInterface {
    String getTitle();
    List<FocusImage> getFocusImages();
    List<LogoImage> getLogoImages();
    String getGenres();
}
