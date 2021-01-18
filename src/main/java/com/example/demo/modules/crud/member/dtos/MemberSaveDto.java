package com.example.demo.modules.crud.member.dtos;

import com.example.demo.commons.enums.DisclosureScopeState;
import com.example.demo.commons.enums.MemberType;
import com.example.demo.commons.enums.PositionType;
import lombok.Builder;
import lombok.Getter;

@Getter @Builder
public class MemberSaveDto {
    private String id;
    private String password;
    private String name;
    private String city;
    private String district;
    private String pictureUri;
    private PositionType position;
    private MemberType type;
    private DisclosureScopeState disclosureScopeState;
}
