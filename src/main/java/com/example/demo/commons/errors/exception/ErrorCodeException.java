package com.example.demo.commons.errors.exception;

import com.example.demo.commons.errors.ErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ErrorCodeException extends RuntimeException {
    private final ErrorCode errorCode;
}
