package com.example.demo.commons.errors.exception;

import com.example.demo.commons.errors.ErrorCode;

public class ClubAlreadyExistException extends ErrorCodeException{
    public ClubAlreadyExistException(){
        this(ErrorCode.CLUB_DUPLICATION);
    }
    private ClubAlreadyExistException(ErrorCode errorCode) {
        super(errorCode);
    }
}
