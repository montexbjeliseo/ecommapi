package com.mtx.ecommerce.exception;

public class DuplicatedResource extends RuntimeException {

    public DuplicatedResource(String message) {
        super(message);
    }
}
