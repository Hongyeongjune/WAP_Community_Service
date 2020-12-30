package com.example.demo.commons.errors.exception;

import com.example.demo.commons.errors.ErrorCode;

public class InvalidJwtAuthenticationException extends ErrorCodeException {

    public InvalidJwtAuthenticationException() {
        this(ErrorCode.INVALID_TOKEN);
    }

    public InvalidJwtAuthenticationException(ErrorCode errorCode) {
        super(errorCode);
    }
}
