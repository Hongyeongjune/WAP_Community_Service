package com.example.demo.apps.community.dtos;

import com.example.demo.modules.crud.community.dtos.PostSaveDto;
import lombok.Getter;

@Getter
public class PostSaveReqDto {

    private String memberId;

    private String clubName;
    private String clubCity;
    private String clubDistrict;

    private String title;
    private String content;

    public PostSaveDto toPostSaveDto() {
        return PostSaveDto.builder()
                .memberId(memberId)
                .clubName(clubName)
                .clubCity(clubCity)
                .clubDistrict(clubDistrict)
                .title(title)
                .content(content)
                .build();
    }
}
