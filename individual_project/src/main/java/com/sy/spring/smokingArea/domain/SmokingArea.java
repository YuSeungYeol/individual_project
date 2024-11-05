package com.sy.spring.smokingArea.domain;


import jakarta.persistence.*;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "smokingArea")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Setter
@Getter
@Builder
public class SmokingArea {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="smokingArea_no")
	private Long smokingAreaNo;
	
	
	 private String address; // 주소
	 private double lat;     // 위도
	 private double lon;     // 경도
}
