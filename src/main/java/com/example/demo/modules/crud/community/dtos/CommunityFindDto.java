package com.example.demo.modules.crud.community.dtos;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CommunityFindDto {

    private String clubName;
    private String clubCity;
    private String clubDistrict;

}
