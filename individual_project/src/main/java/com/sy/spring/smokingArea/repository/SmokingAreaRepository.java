package com.sy.spring.smokingArea.repository;

import com.sy.spring.smokingArea.domain.SmokingArea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SmokingAreaRepository extends JpaRepository<SmokingArea, Long> {

    // 주소를 포함하는 흡연장 검색
    List<SmokingArea> findByAddressContaining(String address);
  
    // 위치 기반 흡연장 검색 (거리 계산 로직 포함)
    @Query(value = "SELECT * FROM individual_project WHERE location = :location AND smoking_area = true", nativeQuery = true)
    List<SmokingArea> findByLocationAndSmokingArea(@Param("location") String location);



} 
