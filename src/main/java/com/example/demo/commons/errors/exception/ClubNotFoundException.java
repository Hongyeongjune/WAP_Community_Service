package com.example.demo.commons.errors.exception;

import com.example.demo.commons.errors.ErrorCode;

public class ClubNotFoundException extends ErrorCodeException {
    public ClubNotFoundException() {
        this(ErrorCode.CLUB_CANNOT_FOUND);
    }
    public ClubNotFoundException(ErrorCode errorCode) {
        super(errorCode);
    }
}
