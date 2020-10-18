package com.almdudleer.labs.testing.lab1.hitchhikers.exceptions;

public class CharacterNotFoundInCurrentLocationException extends RuntimeException {
    public CharacterNotFoundInCurrentLocationException(String message) {
        super(message);
    }
}
