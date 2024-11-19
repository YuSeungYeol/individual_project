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
        // 실제 위치 기반으로 가까운 흡연장 데이터 가져오기
        return smokingAreaRepository.findNearbySmokingAreas(latitude, longitude);
    }
 
    // 검색된 주소를 기준으로 흡연장 검색
    public List<SmokingArea> searchSmokingAreas(String searchQuery) {
        // 장소명으로 흡연장 검색
        return smokingAreaRepository.findByAddressContaining(searchQuery);
    }
}
