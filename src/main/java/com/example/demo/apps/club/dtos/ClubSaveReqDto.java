package com.example.demo.apps.club.dtos;

import com.example.demo.modules.crud.club.dtos.ClubSaveDto;
import lombok.Getter;

@Getter
public class ClubSaveReqDto {

    private String clubName;
    private String city;
    private String district;

    private ClubMemberSaveReqDto leader;

    public ClubSaveDto toClubSaveDto(){
        return ClubSaveDto.builder()
                .clubCity(this.city)
                .clubDistrict(this.district)
                .clubName(this.clubName)
                .leader(this.leader.toClubMemberSaveDto())
                .build();
    }
}
