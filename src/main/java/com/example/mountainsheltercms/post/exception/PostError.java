package com.example.mountainsheltercms.post.exception;

public enum PostError {
    POST_NOT_FOUND("The post has not been found");


    private String message;

    PostError(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}