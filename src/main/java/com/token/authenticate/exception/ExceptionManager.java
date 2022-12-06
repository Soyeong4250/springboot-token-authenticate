package com.token.authenticate.exception;

import com.token.authenticate.domain.entity.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionManager {

    @ExceptionHandler(TokenAuthenticateAppException.class)
    public ResponseEntity<?> tokenAuthenticateAppExceptionHandler(TokenAuthenticateAppException e) {
        return ResponseEntity.status(e.getErrorCode().getStatus()).body(Response.error(e.getErrorCode().getMessage()));
    }
}
