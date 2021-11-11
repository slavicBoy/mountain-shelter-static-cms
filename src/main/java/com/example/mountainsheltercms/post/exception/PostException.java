package com.example.mountainsheltercms.post.exception;

public class PostException extends RuntimeException {

    private PostError postError;

    public PostException(PostError postError) {
        this.postError = postError;
    }

    public PostError getPostError() {
        return postError;
    }
}
