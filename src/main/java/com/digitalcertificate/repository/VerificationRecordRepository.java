package com.digitalcertificate.repository;

import com.digitalcertificate.model.VerificationRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VerificationRecordRepository
        extends JpaRepository<VerificationRecord, Long> {
}