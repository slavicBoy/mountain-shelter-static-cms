package com.example.mountainsheltercms.user.exception;

public enum UserError {

    USER_NOT_FOUND("User has not been found");


    private String message;

    UserError(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
