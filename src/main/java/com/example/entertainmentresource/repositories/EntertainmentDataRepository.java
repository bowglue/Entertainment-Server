package com.example.entertainmentresource.repositories;

import com.example.entertainmentresource.models.entertainment.EntertainmentData;
import com.example.entertainmentresource.models.entertainment.EntertainmentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EntertainmentDataRepository extends JpaRepository<EntertainmentData, Long> {
    List<EntertainmentData> findByEntertainmentType(EntertainmentType entertainmentType);
    @Query("SELECT c FROM EntertainmentData c WHERE c.entertainmentType = ?1 ORDER BY c.id ASC LIMIT ?2")
    List<EntertainmentData> findLimitedEntertainmentDataByEntertainmentType(EntertainmentType entertainmentType, int limit);
}
