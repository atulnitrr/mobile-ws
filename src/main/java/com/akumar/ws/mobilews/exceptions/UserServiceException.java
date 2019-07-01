package com.akumar.ws.mobilews.exceptions;

public class UserServiceException  extends RuntimeException {


    private static final long serialVersionUID = 123456789L;
    public UserServiceException(final String message) {
        super(message);
    }
}
