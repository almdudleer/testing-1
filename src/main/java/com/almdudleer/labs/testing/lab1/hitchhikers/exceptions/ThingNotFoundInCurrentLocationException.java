package com.almdudleer.labs.testing.lab1.hitchhikers.exceptions;

public class ThingNotFoundInCurrentLocationException extends RuntimeException {
    public ThingNotFoundInCurrentLocationException(String message) {
        super(message);
    }
}
