package com.sy.spring.smokingArea.domain;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class SmokingAreaDto {
   
    private Long areaNo;
    private String address;
    private double latitude;
    private double longitude;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
    private String searchQuery;

    // 엔티티를 DTO로 변환
    public SmokingAreaDto toDto(SmokingArea smokingArea) {
        return SmokingAreaDto.builder()
                .areaNo(smokingArea.getAreaNo())
                .address(smokingArea.getAddress())
                .latitude(smokingArea.getLatitude())
                .longitude(smokingArea.getLongitude())
                .createdDate(smokingArea.getCreatedDate())
                .updatedDate(smokingArea.getUpdatedDate())
                .searchQuery(smokingArea.getSearchQuery())
                .build();
    }
 
    // DTO를 엔티티로 변환
    public SmokingArea toEntity() {
        return SmokingArea.builder()
                .areaNo(this.areaNo)
                .address(this.address)
                .latitude(this.latitude)
                .longitude(this.longitude)
                .createdDate(this.createdDate)
                .updatedDate(this.updatedDate)
                .searchQuery(this.searchQuery)
                .build();
    }
}
