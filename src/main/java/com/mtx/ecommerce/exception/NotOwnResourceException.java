package com.mtx.ecommerce.exception;

public class NotOwnResourceException extends RuntimeException {

    public NotOwnResourceException(String message) {
        super(message);
    }
}
