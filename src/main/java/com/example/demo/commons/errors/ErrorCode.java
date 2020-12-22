package com.example.demo.commons.errors;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

    //Member
    MEMBER_CANNOT_FOUND(400, "Can't found member"),

    //Club
    CLUB_CANNOT_FOUND(400, "Can't found Club"),

    //Club Member
    MEMBER_CANNOT_FOUND_IN_CLUB(400, "Can't found member in club"),

    //Community
    COMMUNITY_CANNOT_FOUND(400, "Can't found Community"),

    //Post
    POST_CANNOT_FOUND(400, "Can't found Post");

    private final int code;
    private final String message;
}
