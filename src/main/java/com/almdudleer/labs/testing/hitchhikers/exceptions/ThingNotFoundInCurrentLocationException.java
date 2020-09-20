package com.almdudleer.labs.testing.hitchhikers.exceptions;

public class ThingNotFoundInCurrentLocationException extends RuntimeException {
    public ThingNotFoundInCurrentLocationException(String message) {
        super(message);
    }
}
