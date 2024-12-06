package com.sy.spring.smokingArea.service;

import com.sy.spring.smokingArea.domain.SmokingArea;
import com.sy.spring.smokingArea.repository.SmokingAreaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SmokingAreaService {

    private final SmokingAreaRepository smokingAreaRepository;

    @Autowired
    public SmokingAreaService(SmokingAreaRepository smokingAreaRepository) {
        this.smokingAreaRepository = smokingAreaRepository;
    } 
 
    // 기본 위치 (서울) 기준으로 근처 흡연장 가져오기
    public List<SmokingArea> getSmokingAreas(double latitude, double longitude) {
        double radius = 1000; // 예를 들어 1000m 내에서 검색
        return smokingAreaRepository.findNearbySmokingAreas(latitude, longitude, radius);
    } 

    // 검색된 주소를 기준으로 흡연장 검색
    public List<SmokingArea> searchSmokingAreas(String searchQuery) {
        return smokingAreaRepository.findByAddressContaining(searchQuery);
    }
}
