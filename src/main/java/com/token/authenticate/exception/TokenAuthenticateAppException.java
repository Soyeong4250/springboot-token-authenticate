package com.token.authenticate.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TokenAuthenticateAppException extends RuntimeException {

    private ErrorCode errorCode;
    private String message;

    @Override
    public String toString() {
        if(message == null) return errorCode.getMessage();
        return String.format("%s %s", errorCode.getMessage(), message);
    }
}
