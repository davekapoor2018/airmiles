package com.example.airmiles.exceptionhandler;

public class PostException extends Exception {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private String message;

    public PostException(String message) {
        super();
        this.message = message;
    }

    public String getMessage() {
        return message;
    }


}
