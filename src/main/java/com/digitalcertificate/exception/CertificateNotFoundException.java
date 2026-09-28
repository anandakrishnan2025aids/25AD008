package com.digitalcertificate.exception;

public class CertificateNotFoundException extends RuntimeException {

    public CertificateNotFoundException(String message) {
        super(message);
    }
}