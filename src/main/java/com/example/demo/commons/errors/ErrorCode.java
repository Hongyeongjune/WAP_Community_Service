package com.example.demo.commons.errors;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

    //Member
    MEMBER_CANNOT_FOUND(400, "Can't found member"),
    EMAIL_DUPLICATION(400, "This Email Already Exists"),

    //Club
    CLUB_CANNOT_FOUND(400, "Can't found Club"),
    CLUB_DUPLICATION(400, "This club already exists"),

    //Club Member
    MEMBER_CANNOT_FOUND_IN_CLUB(400, "Can't found member in club"),

    //Community
    COMMUNITY_CANNOT_FOUND(400, "Can't found Community"),

    //Post
    POST_CANNOT_FOUND(400, "Can't found Post"),

    //Security
    INVALID_TOKEN(403, "Invalid JWT token"),
    EXPIRED_TOKEN(403, "Expired JWT Token"),
    HANDLE_ACCESS_DENIED(403, "Access is Denied");

    private final int code;
    private final String message;
}
