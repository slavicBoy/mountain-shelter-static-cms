package com.example.mountainsheltercms.user.role.exception;

import com.example.mountainsheltercms.user.exception.UserError;
import com.example.mountainsheltercms.user.exception.UserException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import shared.ErrorInfo;

@ControllerAdvice
public class RoleExceptionHandler {


    @ExceptionHandler(RoleException.class)
    public ResponseEntity<ErrorInfo> handleException(RoleException e) {
        HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;

        if (RoleError.ROLE_NOT_FOUND.equals(e.getRoleError())) {
            httpStatus = HttpStatus.BAD_REQUEST;
        }
        return ResponseEntity.status(httpStatus).body(new ErrorInfo(e.getRoleError().getMessage()));
    }
}


