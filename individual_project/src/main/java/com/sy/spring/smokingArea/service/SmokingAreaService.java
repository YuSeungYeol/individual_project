package com.sy.spring.smokingArea.service;

import com.sy.spring.smokingArea.domain.SmokingArea;
import com.sy.spring.smokingArea.repository.SmokingAreaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
        // 가까운 흡연장 리스트 가져오기
        List<SmokingArea> allAreas = smokingAreaRepository.findAll();

        // 해당 좌표와의 거리가 radius 이내인 흡연장 필터링
        return allAreas.stream()
                .filter(area -> calculateDistance(area.getLatitude(), area.getLongitude(), latitude, longitude) <= radius)
                .collect(Collectors.toList());
    }

    // 두 지점 사이의 거리 계산 (단위: 미터)
    private double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        final double R = 6371e3; // 지구 반경 (미터 단위)
        double phi1 = Math.toRadians(lat1);
        double phi2 = Math.toRadians(lat2);
        double deltaPhi = Math.toRadians(lat2 - lat1);
        double deltaLambda = Math.toRadians(lon2 - lon1);

        double a = Math.sin(deltaPhi / 2) * Math.sin(deltaPhi / 2) +
                   Math.cos(phi1) * Math.cos(phi2) *
                   Math.sin(deltaLambda / 2) * Math.sin(deltaLambda / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return R * c; // 미터 단위
    }


    // 검색된 주소를 기준으로 흡연장 검색
    public List<SmokingArea> searchSmokingAreas(String searchQuery) {
        return smokingAreaRepository.findByAddressContaining(searchQuery);
    }
}
