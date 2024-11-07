package com.sy.spring.smokingArea.repository;

import com.sy.spring.smokingArea.domain.SmokingArea;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SmokingAreaRepository extends JpaRepository<SmokingArea, Long> {

    // 주소를 포함하는 흡연장 검색
    List<SmokingArea> findByAddressContaining(String address);

    // 위치 기반 흡연장 검색 (거리 계산 로직은 별도로 추가 필요)
    List<SmokingArea> findNearbySmokingAreas(double latitude, double longitude);
}