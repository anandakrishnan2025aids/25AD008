package com.digitalcertificate.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class VerificationRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long verificationId;

    private LocalDateTime verificationTime;

    private String result;

    @ManyToOne
    @JoinColumn(name = "certificate_id")
    private Certificate certificate;

    public Long getVerificationId() {
        return verificationId;
    }

    public void setVerificationId(Long verificationId) {
        this.verificationId = verificationId;
    }

    public LocalDateTime getVerificationTime() {
        return verificationTime;
    }

    public void setVerificationTime(LocalDateTime verificationTime) {
        this.verificationTime = verificationTime;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Certificate getCertificate() {
        return certificate;
    }

    public void setCertificate(Certificate certificate) {
        this.certificate = certificate;
    }
}