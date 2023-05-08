package com.example.entertainmentresource.services;

import com.example.entertainmentresource.models.image.BaseImage;
import com.example.entertainmentresource.repositories.BaseImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BaseImageService{
    @Autowired
    private BaseImageRepository baseImageRepository;

    public <T extends BaseImage> void saveAllImages(List<T> baseImages){
        baseImageRepository.saveAllAndFlush(baseImages);
    }

    public <T extends BaseImage> void saveImage(T baseImages){
        baseImageRepository.saveAndFlush(baseImages);
    }
}
