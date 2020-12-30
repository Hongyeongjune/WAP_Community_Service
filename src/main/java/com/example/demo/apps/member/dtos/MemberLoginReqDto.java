package com.example.demo.apps.member.dtos;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MemberLoginReqDto {
    private String id;
    private String password;
}
