package com.example.demo.commons.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum CommunityMemberType {
    MEMBER("팀원"), LEADER("리더");

    private String name;
}
