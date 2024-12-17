package com.sy.spring.smokingArea.controller;

import com.sy.spring.smokingArea.domain.SmokingArea;
import com.sy.spring.smokingArea.domain.SmokingAreaDto;
import com.sy.spring.smokingArea.service.SmokingAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class SmokingAreaController {

    private final SmokingAreaService smokingAreaService;

    @Autowired
    public SmokingAreaController(SmokingAreaService smokingAreaService) {
        this.smokingAreaService = smokingAreaService;
    }
 
    // 검색 페이지 로드
    @GetMapping("/place")
    public String getSmokingAreaPage(@ModelAttribute("searchDto") SmokingAreaDto smokingAreaDto, Model model) {
        // 기본 위치 (서울) 기준으로 흡연장 목록을 가져오기
        List<SmokingArea> smokingAreas = smokingAreaService.getSmokingAreas(37.5665, 126.9780);
        model.addAttribute("smokingAreas", smokingAreas);
        return "place/placeOriginal"; // 템플릿 경로 확인
    }

    // 검색 후 근처 흡연장 검색
    @GetMapping("/place/search")
    public String searchSmokingArea(@RequestParam("query") String searchQuery, Model model) {
        // 검색된 장소명을 기준으로 흡연장 검색
        List<SmokingArea> smokingAreas = smokingAreaService.searchSmokingAreas(searchQuery);
        model.addAttribute("smokingAreas", smokingAreas);
        model.addAttribute("searchQuery", searchQuery);
        return "place/placeOriginal"; // 템플릿 경로 확인
    }

    @GetMapping("/api/smoking-areas")
    @ResponseBody
    public List<SmokingArea> getSmokingAreas(@RequestParam(name = "lat") double lat,
                                             @RequestParam(name = "lon") double lon) {
        System.out.println("Received lat: " + lat + ", lon: " + lon);
        return smokingAreaService.getSmokingAreas(lat, lon);
    }

}
