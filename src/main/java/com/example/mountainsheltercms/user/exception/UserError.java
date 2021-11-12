package com.example.mountainsheltercms.user.exception;

public enum UserError {

    USER_NOT_FOUND("User has not been found"),
    USERNAME_IS_TAKEN("Username is already taken"),
    EMAIL_IS_TAKEN("E-mail is already taken");


    private String message;

    UserError(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
