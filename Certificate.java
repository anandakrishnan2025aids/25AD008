package com.digitalcertificate.Model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Certificate {

    @Id
    private String certificateId;

    private String verificationCode;

    private LocalDate issueDate;

    private boolean revoked;

    private LocalDateTime revokedDate;

}