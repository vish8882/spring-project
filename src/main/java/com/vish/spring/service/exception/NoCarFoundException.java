package com.vish.spring.service.exception;

import java.util.NoSuchElementException;

public class NoCarFoundException extends NoSuchElementException {

    public NoCarFoundException(String message) {
        super(message);
    }
}
