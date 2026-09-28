package com.digitalcertificate.repository;

import com.digitalcertificate.model.Certificate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CertificateRepository
        extends JpaRepository<Certificate, String> {

    Optional<Certificate> findByVerificationCode(String verificationCode);

    boolean existsByVerificationCode(String verificationCode);
}