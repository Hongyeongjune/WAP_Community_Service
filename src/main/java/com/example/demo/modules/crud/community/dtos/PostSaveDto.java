package com.example.demo.modules.crud.community.dtos;

import com.example.demo.modules.crud.community.entitiys.Community;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PostSaveDto {
    private String memberId;

    private String clubName;
    private String clubCity;
    private String clubDistrict;

    private String title;
    private String content;
}
