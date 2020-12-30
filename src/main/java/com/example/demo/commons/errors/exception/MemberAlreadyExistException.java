package com.example.demo.commons.errors.exception;

import com.example.demo.commons.errors.ErrorCode;

public class MemberAlreadyExistException extends ErrorCodeException {
    public MemberAlreadyExistException() {
        this(ErrorCode.EMAIL_DUPLICATION);
    }

    private MemberAlreadyExistException(ErrorCode errorCode) {
        super(errorCode);
    }
}
