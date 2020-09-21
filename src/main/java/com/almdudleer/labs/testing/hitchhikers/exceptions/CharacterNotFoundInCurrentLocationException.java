package com.almdudleer.labs.testing.hitchhikers.exceptions;

public class CharacterNotFoundInCurrentLocationException extends RuntimeException {
    public CharacterNotFoundInCurrentLocationException(String message) {
        super(message);
    }
}
