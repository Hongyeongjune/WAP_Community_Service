package com.example.demo.modules.crud.community.dtos;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PostDeleteDto {

    private Long postId;
    private String memberId;

    private String clubName;
    private String clubCity;
    private String clubDistrict;

}
