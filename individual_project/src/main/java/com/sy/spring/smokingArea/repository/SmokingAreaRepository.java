package com.sy.spring.smokingArea.repository;

import com.sy.spring.smokingArea.domain.SmokingArea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SmokingAreaRepository extends JpaRepository<SmokingArea, Long> {

    // 주소를 포함하는 흡연장 검색
    List<SmokingArea> findByAddressContaining(String address);
 
    // 위치 기반 흡연장 검색 (거리 계산 로직 포함)
    @Query("SELECT s FROM SmokingArea s WHERE " +
           "POW((s.latitude - :latitude), 2) + POW((s.longitude - :longitude), 2) < POW(:radius, 2)")
    List<SmokingArea> findNearbySmokingAreas(double latitude, double longitude, double radius);
} 
