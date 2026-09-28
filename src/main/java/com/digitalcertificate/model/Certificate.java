package com.digitalcertificate.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Certificate {
    @ManyToOne
    @JoinColumn(name = "participant_id")
    private Participant participant;
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;
    @OneToMany(mappedBy = "certificate")
    private List<VerificationRecord> verificationRecords;

    @Id
    private String certificateId;

    private String verificationCode;

    private LocalDate issueDate;

    private boolean revoked;

    private LocalDateTime revokedDate;
    public String getCertificateId() {
        return certificateId;
    }

    public void setCertificateId(String certificateId) {
        this.certificateId = certificateId;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public boolean isRevoked() {
        return revoked;
    }

    public void setRevoked(boolean revoked) {
        this.revoked = revoked;
    }

    public LocalDateTime getRevokedDate() {
        return revokedDate;
    }

    public void setRevokedDate(LocalDateTime revokedDate) {
        this.revokedDate = revokedDate;
    }

    public Participant getParticipant() {
        return participant;
    }

    public void setParticipant(Participant participant) {
        this.participant = participant;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public List<VerificationRecord> getVerificationRecords() {
        return verificationRecords;
    }

    public void setVerificationRecords(List<VerificationRecord> verificationRecords) {
        this.verificationRecords = verificationRecords;

    }

}

