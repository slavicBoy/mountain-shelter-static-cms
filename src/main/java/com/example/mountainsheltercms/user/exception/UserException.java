package com.example.mountainsheltercms.user.exception;


public class UserException extends RuntimeException{

    private UserError userError;

    public UserException(UserError userError) {
        this.userError = userError;
    }

    public UserError getPostError() {
        return userError;
    }
}
