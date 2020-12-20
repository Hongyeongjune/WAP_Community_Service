package com.example.demo.domain.club.dtos;

import com.example.demo.commons.enums.ClubMemberType;
import com.example.demo.commons.enums.PositionType;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ClubMemberSaveDto {
    private String memberId;
    private String clubName;
    private String clubCity;
    private String clubDistrict;
    private int uniformNum;
    private PositionType positionType;
    private ClubMemberType clubMemberType;
}

