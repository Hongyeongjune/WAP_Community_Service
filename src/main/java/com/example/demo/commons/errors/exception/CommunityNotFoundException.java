package com.example.demo.commons.errors.exception;

import com.example.demo.commons.errors.ErrorCode;

public class CommunityNotFoundException extends ErrorCodeException {
    public CommunityNotFoundException() {
        this(ErrorCode.COMMUNITY_CANNOT_FOUND);
    }
    public CommunityNotFoundException(ErrorCode errorCode) {
        super(errorCode);
    }
}
