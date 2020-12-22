package com.example.demo.commons.errors.exception;

import com.example.demo.commons.errors.ErrorCode;

public class PostNotFoundException extends ErrorCodeException {
    public PostNotFoundException() {
        this(ErrorCode.POST_CANNOT_FOUND);
    }

    public PostNotFoundException(ErrorCode errorCode) {
        super(errorCode);
    }
}
