package com.example.entertainmentresource.repositories;

import com.example.entertainmentresource.models.slider.PageType;
import com.example.entertainmentresource.models.slider.SliderData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SliderDataRepository extends JpaRepository<SliderData, Long> {
    List<SliderData> findByPageOrderBySortId(PageType pageType);
}
