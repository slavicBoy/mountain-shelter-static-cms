package com.example.mountainsheltercms.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import shared.ErrorInfo;

@ControllerAdvice
public class UserExceptionHandler {

    @ExceptionHandler(UserException.class)
    public ResponseEntity<ErrorInfo> handleException(UserException e){
        HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;

        if(UserError.USER_NOT_FOUND.equals(e.getPostError())){
            httpStatus = HttpStatus.BAD_REQUEST;
        }

        return ResponseEntity.status(httpStatus).body(new ErrorInfo(e.getPostError().getMessage()));
    }
}