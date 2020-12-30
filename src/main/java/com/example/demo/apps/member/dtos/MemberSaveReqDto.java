package com.example.demo.apps.member.dtos;

import com.example.demo.commons.enums.DisclosureScopeState;
import com.example.demo.commons.enums.MemberType;
import com.example.demo.commons.enums.PositionType;
import com.example.demo.modules.crud.member.dtos.MemberSaveDto;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MemberSaveReqDto {

    private String id;
    private String password;
    private String name;
    private String city;
    private String district;
    private PositionType position;
    private MemberType type;
    private DisclosureScopeState disclosureScopeState;

    public MemberSaveDto toMemberSaveDto(String encodedPW){
        return MemberSaveDto.builder()
                .id(this.id)
                .password(encodedPW)
                .city(this.city)
                .district(this.district)
                .name(this.name)
                .position(this.position)
                .type(this.type)
                .disclosureScopeState(this.disclosureScopeState)
                .build();
    }

}
