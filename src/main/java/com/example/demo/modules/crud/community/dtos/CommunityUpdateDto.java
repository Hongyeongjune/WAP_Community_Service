package com.example.demo.modules.crud.community.dtos;

import lombok.Getter;

@Getter
public class CommunityUpdateDto {
    private String title;
    private String content;

    private String clubName;
    private String clubCity;
    private String clubDistrict;

    private String memberId;

}
