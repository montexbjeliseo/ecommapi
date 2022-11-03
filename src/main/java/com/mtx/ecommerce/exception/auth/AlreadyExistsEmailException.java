package com.mtx.ecommerce.exception.auth;

public class AlreadyExistsEmailException extends RuntimeException {
    public AlreadyExistsEmailException(String message){
        super(message);
    }           
}
