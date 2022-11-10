package com.mtx.ecommerce.exception.controller;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.mtx.ecommerce.exception.DuplicatedResourceException;
import com.mtx.ecommerce.exception.NotOwnResourceException;
import com.mtx.ecommerce.exception.ParameterNotFoundException;
import com.mtx.ecommerce.exception.ResourceNotFoundException;
import com.mtx.ecommerce.exception.SearchResultNotFoundException;
import com.mtx.ecommerce.exception.auth.AlreadyExistsEmailException;
import com.mtx.ecommerce.exception.dto.ExceptionDto;
import io.jsonwebtoken.JwtException;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerController extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
            HttpHeaders headers,
            HttpStatus status,
            WebRequest request) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {

            String fieldName = ((FieldError) error).getField();
            String message = error.getDefaultMessage();
            errors.put(fieldName, message);
        });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {AlreadyExistsEmailException.class})
    protected ResponseEntity<?> handleException(AlreadyExistsEmailException ex,
            WebRequest request) {
        ExceptionDto message = new ExceptionDto(
                HttpStatus.BAD_REQUEST.value(),
                new Date(),
                ex.getMessage(),
                request.getDescription(false));

        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {UsernameNotFoundException.class})
    protected ResponseEntity<?> handleException(UsernameNotFoundException ex,
            WebRequest request) {
        ExceptionDto message = new ExceptionDto(
                HttpStatus.NOT_FOUND.value(),
                new Date(),
                ex.getMessage(),
                request.getDescription(false));

        return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {IOException.class})
    protected ResponseEntity<?> handleException(IOException ex,
            WebRequest request) {
        ExceptionDto message = new ExceptionDto(
                HttpStatus.NOT_FOUND.value(),
                new Date(),
                ex.getMessage(),
                request.getDescription(false));

        return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {ServletException.class})
    protected ResponseEntity<?> handleException(ServletException ex,
            WebRequest request) {
        ExceptionDto message = new ExceptionDto(
                HttpStatus.BAD_REQUEST.value(),
                new Date(),
                ex.getMessage(),
                request.getDescription(false));

        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {BadCredentialsException.class})
    protected ResponseEntity<?> handleException(BadCredentialsException ex,
            WebRequest request) {
        ExceptionDto message = new ExceptionDto(
                HttpStatus.BAD_REQUEST.value(),
                new Date(),
                ex.getMessage(),
                request.getDescription(false));

        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {JwtException.class})
    protected ResponseEntity<?> handleException(JwtException ex,
            WebRequest request) {
        ExceptionDto message = new ExceptionDto(
                HttpStatus.UNAUTHORIZED.value(),
                new Date(),
                ex.getMessage(),
                request.getDescription(false));

        return new ResponseEntity<>(message, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(value = {AuthenticationException.class})
    protected ResponseEntity<?> handleException(AuthenticationException ex,
            WebRequest request) {
        ExceptionDto message = new ExceptionDto(
                HttpStatus.UNAUTHORIZED.value(),
                new Date(),
                ex.getMessage(),
                request.getDescription(false));

        return new ResponseEntity<>(message, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(value = {ResourceNotFoundException.class})
    protected ResponseEntity<?> handleException(ResourceNotFoundException ex,
            WebRequest request) {
        ExceptionDto message = new ExceptionDto(
                HttpStatus.NOT_FOUND.value(),
                new Date(),
                ex.getMessage(),
                request.getDescription(false));

        return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {ParameterNotFoundException.class})
    protected ResponseEntity<?> handleException(ParameterNotFoundException ex,
            WebRequest request) {
        ExceptionDto message = new ExceptionDto(
                HttpStatus.BAD_REQUEST.value(),
                new Date(),
                ex.getMessage(),
                request.getDescription(false));

        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {DuplicatedResourceException.class})
    protected ResponseEntity<?> handleException(DuplicatedResourceException ex,
            WebRequest request) {
        ExceptionDto message = new ExceptionDto(
                HttpStatus.BAD_REQUEST.value(),
                new Date(),
                ex.getMessage(),
                request.getDescription(false));

        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {SearchResultNotFoundException.class})
    protected ResponseEntity<?> handleException(SearchResultNotFoundException ex,
            WebRequest request) {
        ExceptionDto message = new ExceptionDto(
                HttpStatus.NO_CONTENT.value(),
                new Date(),
                ex.getMessage(),
                request.getDescription(false));

        return new ResponseEntity<>(message, HttpStatus.NO_CONTENT);
    }

    @ExceptionHandler(value = {NotOwnResourceException.class})
    protected ResponseEntity<?> handleException(NotOwnResourceException ex,
            WebRequest request) {
        ExceptionDto message = new ExceptionDto(
                HttpStatus.BAD_REQUEST.value(),
                new Date(),
                ex.getMessage(),
                request.getDescription(false));

        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {InvalidFormatException.class})
    protected ResponseEntity<?> handleException(InvalidFormatException ex,
            WebRequest request) {
        ExceptionDto message = new ExceptionDto(
                HttpStatus.BAD_REQUEST.value(),
                new Date(),
                ex.getMessage(),
                request.getDescription(false));

        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {HttpMessageNotReadableException.class})
    protected ResponseEntity<?> handleException(HttpMessageNotReadableException ex,
            WebRequest request) {
        ExceptionDto message = new ExceptionDto(
                HttpStatus.BAD_REQUEST.value(),
                new Date(),
                ex.getMessage(),
                request.getDescription(false));

        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }

}
