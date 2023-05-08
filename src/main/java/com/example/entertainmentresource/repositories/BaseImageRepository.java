package com.example.entertainmentresource.repositories;

import com.example.entertainmentresource.models.image.BaseImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BaseImageRepository  extends JpaRepository<BaseImage, Long> {
}

