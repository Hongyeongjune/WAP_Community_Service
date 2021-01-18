package com.example.demo.apps.club.dtos;

import com.example.demo.commons.enums.ClubMemberType;
import com.example.demo.commons.enums.PositionType;
import com.example.demo.modules.crud.club.dtos.ClubMemberSaveDto;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ClubMemberSaveReqDto {
    private String clubName;
    private String clubCity;
    private String clubDistrict;
    private String memberId;
    private int uniformNum;
    private PositionType positionType;
    private ClubMemberType clubMemberType;

    public ClubMemberSaveDto toClubMemberSaveDto(){
        return ClubMemberSaveDto.builder()
                .clubCity(this.clubCity)
                .clubDistrict(this.clubDistrict)
                .clubName(this.clubName)
                .clubMemberType(this.clubMemberType)
                .memberId(this.memberId)
                .positionType(this.positionType)
                .uniformNum(this.uniformNum)
                .build();
    }
}

