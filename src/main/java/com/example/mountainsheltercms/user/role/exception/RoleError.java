package com.example.mountainsheltercms.user.role.exception;

public enum RoleError {

    ROLE_NOT_FOUND("Role has not been found");

    private String message;

    RoleError(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
