package com.example.demo.commons.errors.exception;

import com.example.demo.commons.errors.ErrorCode;

public class MemberNotFoundException extends ErrorCodeException {

    public MemberNotFoundException() {
        this(ErrorCode.MEMBER_CANNOT_FOUND);
    }

    private MemberNotFoundException(ErrorCode errorCode) {
        super(errorCode);
    }
}
