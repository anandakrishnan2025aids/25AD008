package com.digitalcertificate.exception;

public class CertificateRevokedException extends RuntimeException {

    public CertificateRevokedException(String message) {
        super(message);
    }
}