package com.example.demo.commons.errors.exception;

import com.example.demo.commons.errors.ErrorCode;

public class ClubMemberNotFoundException extends ErrorCodeException {

    public ClubMemberNotFoundException(){
        this(ErrorCode.MEMBER_CANNOT_FOUND_IN_CLUB);
    }

    public ClubMemberNotFoundException(ErrorCode errorCode) {
        super(errorCode);
    }
}
