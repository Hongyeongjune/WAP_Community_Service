package com.example.demo.commons.errors.exception;

import com.example.demo.commons.errors.ErrorCode;

public class AccessDeniedAuthenticationException extends ErrorCodeException {

    public AccessDeniedAuthenticationException() {
        this(ErrorCode.HANDLE_ACCESS_DENIED);
    }
    public AccessDeniedAuthenticationException(ErrorCode errorCode) {
        super(errorCode);
    }
}
