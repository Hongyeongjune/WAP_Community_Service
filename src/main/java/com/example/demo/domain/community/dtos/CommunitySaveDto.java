package com.example.demo.domain.community.dtos;

import com.example.demo.domain.club.dtos.ClubMemberSaveDto;
import com.example.demo.domain.club.dtos.ClubSaveDto;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CommunitySaveDto {

    private String title;
    private String content;
    private int like;
    private ClubSaveDto club;
    private ClubMemberSaveDto clubMember;

}
