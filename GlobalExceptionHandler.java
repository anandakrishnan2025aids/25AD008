package com.digitalcertificate.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(CertificateNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String,String> handleNotFound(
            CertificateNotFoundException ex) {

        return Map.of(
                "error",
                ex.getMessage());
    }
    @ExceptionHandler(CertificateRevokedException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String,String> handleRevoked(
            CertificateRevokedException ex) {

        return Map.of(
                "error",
                ex.getMessage());
    }
    @ExceptionHandler(
            DuplicateVerificationCodeException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String,String> handleDuplicate(
            DuplicateVerificationCodeException ex) {

        return Map.of(
                "error",
                ex.getMessage());
    }

}