package com.example.demo.modules.crud.club.dtos;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ClubSaveDto {
    private String clubName;
    private String clubCity;
    private String clubDistrict;
    private String logoUri;
    private ClubMemberSaveDto leader;
}

