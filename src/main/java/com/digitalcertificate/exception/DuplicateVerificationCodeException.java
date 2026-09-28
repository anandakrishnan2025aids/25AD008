package com.digitalcertificate.exception;

public class DuplicateVerificationCodeException extends RuntimeException {

    public DuplicateVerificationCodeException(String message) {
        super(message);
    }
}