package com.example.mountainsheltercms.post.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import shared.ErrorInfo;

@ControllerAdvice
public class PostExceptionHandler {


    @ExceptionHandler(PostException.class)
    public ResponseEntity<ErrorInfo> handleException(PostException e){
        HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        if(PostError.POST_NOT_FOUND.equals(e.getPostError())){
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        }

        return ResponseEntity.status(httpStatus).body(new ErrorInfo(e.getPostError().getMessage()));
    }
}
