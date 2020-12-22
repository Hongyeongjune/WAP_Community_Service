package com.example.demo.modules.crud.community.dtos;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CommunitySaveDto {

    private String title;
    private String content;
    private int like;

    private String clubName;
    private String clubCity;
    private String clubDistrict;

    private String memberId;

}
